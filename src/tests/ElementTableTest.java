package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Category;
import main.java.modele.ElementTable;
import main.java.modele.Project;

public class ElementTableTest {
	
	private ElementTable elmtable;
	private Project project;
	private Project project1;

	private static final String PROJECT1_NAME = "Projet 1";
	@BeforeEach
	public void before() {
		project = new Project(PROJECT1_NAME, "Descript1");
		project1 = new Project("Projet", "Descript");
		elmtable = new ElementTable(project, Category.BPMN);

	}

	@Test
	public void verificationGetNameTest() {
		assertEquals(PROJECT1_NAME, elmtable.getName());

	}

	@Test
	public void verificationSetNameTest() {
		assertEquals(PROJECT1_NAME, elmtable.getName());
		elmtable.setName("Projet 2");
		assertEquals("Projet 2", elmtable.getName());
	}
	@Test
	public void verificationGetProjectTest() {
		assertEquals(project, elmtable.getProject());

	}

	@Test
	public void verificationSetProjectTest() {
		assertEquals(project, elmtable.getProject());
		elmtable.setProject(project1);
		assertEquals(project1, elmtable.getProject());
	}
	
	@Test
	public void verificationGetCategoryTest() {
		assertEquals(Category.BPMN, elmtable.getCategory());

	}

	@Test
	public void verificationSetCategoryTest() {
		assertEquals(Category.BPMN, elmtable.getCategory());
		elmtable.setCategory(Category.MCF);
		assertEquals(Category.MCF, elmtable.getCategory());
	}

}
