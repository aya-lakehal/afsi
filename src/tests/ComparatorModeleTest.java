package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.exception.CategoryNotFound;
import main.java.modele.Category;
import main.java.modele.ComparatorModele;
import main.java.modele.Fichier;
import main.java.modele.pojo.bpmn.Line;
import main.java.modele.pojo.mcf.Actor;
import main.java.modele.pojo.mcf.Objective;

class ComparatorModeleTest {

	private ComparatorModele comparatorModele;
	private Fichier fileMcf;
	private Fichier fileBpmnCorrupt;
	
	
	private static final String PATH_BPMN = "src/tests/ressources/bpmnTest.bpmn";
	private static final String PATH_MCF = "src/tests/ressources/testMcf.csv";
	private static final String PATH_BPMN_CORRUPT = "src/tests/ressources/corrompu.bpmn";

	@BeforeEach
	void setUp() {
		fileBpmnCorrupt = new Fichier("corrupt", Category.BPMN);
		fileBpmnCorrupt.setFile(new File(PATH_BPMN_CORRUPT));
		Fichier fileBpmn = new Fichier("bpmn", Category.BPMN);
		fileBpmn.setFile(new File(PATH_BPMN));
		fileMcf = new Fichier("mcf", Category.MCF);
		fileMcf.setFile(new File(PATH_MCF));
		List<Fichier> files = List.of(fileBpmn,fileMcf);
		comparatorModele = new ComparatorModele(files);
		this.initialiseBpmnAndMcf();
	}

	@Test
	void testCompareSI() {
		assertTrue(this.comparatorModele.compareSI());
		
		this.comparatorModele.setFiles(List.of(fileMcf,fileBpmnCorrupt));
		this.initialiseBpmnAndMcf();
		
		assertFalse(this.comparatorModele.compareSI());
	}
	@Test
	void testCompareNamesOfActors() {
		assertTrue(this.comparatorModele.compareNameActors());
		
		this.comparatorModele.setFiles(List.of(fileMcf,fileBpmnCorrupt));
		this.initialiseBpmnAndMcf();

		assertFalse(this.comparatorModele.compareNameActors());
	}
	@Test
	void testCompareNamesOfFlows() {
		assertTrue(this.comparatorModele.compareNameOfFlows());
		
		this.comparatorModele.setFiles(List.of(fileMcf,fileBpmnCorrupt));
		this.initialiseBpmnAndMcf();

		assertFalse(this.comparatorModele.compareNameOfFlows());
	}
	@Test
	void testCompareNumberOfActors() {
		assertTrue(this.comparatorModele.compareNumberActors());
		Actor actor = new Actor("1", "actor");
		this.comparatorModele.getMcf().getActors().add(actor);
		assertFalse(this.comparatorModele.compareNumberActors());
	}
	@Test
	void testCompareNumberOfObjectives() {
		assertTrue(this.comparatorModele.compareNumberObjectives());
		int numberOfObjectivesMcf = this.comparatorModele.getMcf().getObjectives().size();
		int numberOfObjectivesBpmn = this.comparatorModele.getBpmn().getMainPool().getLines().size();
		assertEquals(numberOfObjectivesMcf,numberOfObjectivesBpmn);
		
		numberOfObjectivesMcf++;
		this.comparatorModele.getMcf().getObjectives().add(null);
		assertFalse(this.comparatorModele.compareNumberObjectives());
		assertNotEquals(numberOfObjectivesMcf,numberOfObjectivesBpmn);
	}
	@Test
	void testCompareNamesOfObjectives() {
		assertTrue(this.comparatorModele.compareObjectives());
		String idObj = "666";
		String nameObj = "dark";
		Objective objective = new Objective(idObj, nameObj);
		this.comparatorModele.getMcf().getObjectives().add(objective);
		assertFalse(this.comparatorModele.compareObjectives());
		
		Line objectiveBpmn = new Line(idObj, nameObj);
		this.comparatorModele.getBpmn().getMainPool().getLines().add(objectiveBpmn);
		assertTrue(this.comparatorModele.compareObjectives());
	}
	@Test
	void testCompareTargetEvent() {
		assertTrue(this.comparatorModele.compareTargetEvent());
		this.comparatorModele.setFiles(List.of(fileMcf,fileBpmnCorrupt));
		this.initialiseBpmnAndMcf();
		assertFalse(this.comparatorModele.compareTargetEvent());
	}
	
	@Test
	void testThrowExceptionWhenCategoryDoesNotExist() {
		Fichier f1 = new Fichier("test1", null);
		Fichier f2 = new Fichier("test2", null);
		List<Fichier> files = List.of(f1,f2);
		this.comparatorModele.setFiles(files);
		
		Exception exception = assertThrows(CategoryNotFound.class, () -> this.comparatorModele.initializeBpmn());

	    String expectedMessage = "Category not found";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception = assertThrows(CategoryNotFound.class, () -> this.comparatorModele.initializeMcf());
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testStringCompare() {
		String expected = """
				Nom des acteurs : Valide\n\n
				Nom du systeme d'information : Valide\n\n
				Nom des acteurs internes/objectifs : Valide\n\n
				Nombre de flux : Valide\n\n
				Nombre d'acteur : Valide\n\n
				Nombre d'acteur interne/objectif : Valide\n\n
				Liaison des flux : Valide""";
		String actual = this.comparatorModele.compare();
		assertEquals(expected, actual);
	}
	private void initialiseBpmnAndMcf() {
		try {
			comparatorModele.initializeBpmn();
			comparatorModele.initializeMcf();
		} catch (CategoryNotFound e) {
			e.printStackTrace();
		}
	}

}
