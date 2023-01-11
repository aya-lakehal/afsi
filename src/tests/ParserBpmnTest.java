package tests;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.modele.ParserBpmn;
import main.java.modele.pojo.bpmn.Bpmn;

public class ParserBpmnTest {

	private ParserBpmn parser;
	private Bpmn bpmn;

	@BeforeEach
	public void before() {

		parser = new ParserBpmn();
	}

	@Test
	public void verificationBpmnNullTest() {
		assertNull(bpmn);

	}

}
