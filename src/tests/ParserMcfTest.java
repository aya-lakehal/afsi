package tests;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.ParserMcf;
import main.java.modele.pojo.mcf.Mcf;

public class ParserMcfTest {

	private ParserMcf parser;
	private Mcf mcf;

	@BeforeEach
	public void before() {

		parser = new ParserMcf();
	}

	@Test
	public void verificationMcfNullTest() {
		assertNull(mcf);

	}

}
