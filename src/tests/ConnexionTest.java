package tests;

import static org.junit.Assert.assertNull;

import javax.naming.directory.DirContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Connexion;

public class ConnexionTest {
	
	private Connexion connexion;
	private DirContext context;
	private boolean connected = true;

	@BeforeEach
	public void before() {

		connexion = new Connexion();
		
	}

	@Test
	public void verifyContextIsNullTest() {
		assertNull(context);

	}

}
