package main.java.modele;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import main.java.modele.pojo.bpmn.Bpmn;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParserBpmn {

	private Bpmn bpmn;

	public ParserBpmn() {
		this.bpmn = new Bpmn();
	}

	public void parse(String path) {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		} catch (SAXNotRecognizedException | SAXNotSupportedException | ParserConfigurationException e1) {
			e1.printStackTrace();
		}

		try (InputStream is = new FileInputStream(new File(path))) {

			SAXParser saxParser = factory.newSAXParser();

			MapBpmnObjectHandlerSax handler = new MapBpmnObjectHandlerSax();

			saxParser.parse(is, handler);

			this.bpmn.setPools(handler.getResult());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public Bpmn getBpmn() {
		return bpmn;
	}

	public void setBpmn(Bpmn bpmn) {
		this.bpmn = bpmn;
	}

}
