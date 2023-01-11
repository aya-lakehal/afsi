package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Category;
import main.java.modele.Fichier;
import main.java.modele.Project;

/**
 * The testing class
 */

public class ProjectTest {

	private Project project;
	private Fichier fichier1;
	private Fichier fichier2;
	private File f1;
	private File f2;

	private static final String DESCRIPTION = "Descript1";
	private static final String PROJET1 = "Projet 1";
	@BeforeEach
	public void before() {
		project = new Project(PROJET1, DESCRIPTION);
		fichier1 = new Fichier("Fichier Bpmn", Category.BPMN, f1);
		fichier2 = new Fichier("Fichier MCF", Category.MCF, f2);

	}

	@Test
	public void verificationGetNameTest() {
		assertEquals(PROJET1, project.getName());

	}

	@Test
	public void verificationSetNameTest() {
		assertEquals(PROJET1, project.getName());
		project.setName("Project2");
		assertEquals("Project2", project.getName());
	}

	@Test
	public void verificationGetDescriptionTest() {
		assertEquals(DESCRIPTION, project.getDescription());

	}

	@Test
	public void verificationSetDescriptionTest() {
		assertEquals(DESCRIPTION, project.getDescription());
		project.setDescription("Descript2");
		assertEquals("Descript2", project.getDescription());
	}

	@Test
	public void verificationGetFileTest() {
		assertEquals(0, this.project.getFiles().size());
		project.addFile(fichier1);
		assertEquals(1, this.project.getFiles().size());

		project.addFile(fichier2);
		assertEquals(2, this.project.getFiles().size());

	}

	@Test
	public void verificationEmptyFileTest() {
		assertTrue(this.project.isEmpty());
	}

	@Test
	public void verificationGetFileByCategoryTest() {

		project.addFile(fichier1);
		project.addFile(fichier2);

		assertEquals(fichier1, project.getFilesByCategory(Category.BPMN).get(0));
		assertEquals(fichier2, project.getFilesByCategory(Category.MCF).get(0));

	}

}