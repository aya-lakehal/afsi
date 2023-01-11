package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Category;
import main.java.modele.Fichier;
import main.java.modele.ImportFile;

public class ImporteFileTest {
	
	private static final String BPMN_STRING = "Fichier BPMN";
	private ImportFile imFile;
	private Fichier fichier;
	private File f;
	private String nameFile;
	

	@BeforeEach
	public void before() {
		
		fichier = new Fichier(BPMN_STRING, Category.BPMN, f);
		imFile = new ImportFile();
		nameFile = f.getName();
		
	}

	//@Test
	//public void getNameWithoutExtensionTest() {
		//nameFile = "fichier.bpmn";
		//assertEquals("fichier.bpmn", f.getName());
		//assertEquals("fichier", imFile.getNameFileWithoutExtension(f));		
	//}

}
