package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.Inscription;

/**
 * The testing class
 */

public class InscriptionTest {
	

         private Inscription inscription;
	
	@BeforeEach
	public void before() {
		inscription = new Inscription("Louis22","louis");
	}

	@Test
	public void verificationGetLoginTest() {
		assertEquals("Louis22", inscription.getLogin());

	}

	@Test
	public void verificationGetPassWordTest() {
		assertEquals("louis", inscription.getPassword());

	}

}