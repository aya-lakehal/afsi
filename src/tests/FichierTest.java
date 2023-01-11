package tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Category;
import main.java.modele.Fichier;

/**
 * The testing class
 */

public class FichierTest {

	
	private Fichier fichier1;
	private Fichier fichier2;
	private File f1;
	private File f2;
	
	private static final String BPMN_STRING = "Fichier Bpmn";
	private static final String MCF_STRING = "Fichier MCF";
	private static final String BPMNBIS_STRING = "Fichier BpmnBis";

	@BeforeEach
	public void before() {
		
		fichier1 = new Fichier(BPMN_STRING, Category.BPMN, f1);
		fichier2 = new Fichier(MCF_STRING, Category.MCF);
	}

	@Test
	public void verificationGetNameTest() {
		assertEquals(BPMN_STRING, fichier1.getName());
		assertEquals(MCF_STRING, fichier2.getName());

	}

	@Test
	public void verificationSetNameTest() {
		assertEquals(BPMN_STRING, fichier1.getName());
		fichier1.setName(BPMNBIS_STRING);
		assertEquals(BPMNBIS_STRING, fichier1.getName());
	}
	
	@Test
	public void verificationGetCategoryTest() {
		assertEquals(Category.BPMN, fichier1.getCategory());
		assertEquals(Category.MCF, fichier2.getCategory());

	}

	@Test
	public void verificationSetCategoryTest() {
		assertEquals(Category.BPMN, fichier1.getCategory());
		fichier1.setCategory(Category.MCF);
		assertEquals(Category.MCF, fichier1.getCategory());
	}
	
	@Test
	public void verificationGetFileTest() {
		assertEquals(f1, fichier1.getFile());
		
	}

	@Test
	public void verificationSetFileTest() {
		assertEquals(f1, fichier1.getFile());
		fichier1.setFile(f2);
		assertEquals(f2, fichier1.getFile());
	}
	
	@Test
	public void verificationGetPathTest() {
		assertNull(f1);
		
	}
	
	
}