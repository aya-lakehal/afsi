package main.java.modele;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import main.java.modele.pojo.bpmn.EntityBpmn;
import main.java.modele.pojo.bpmn.Event;
import main.java.modele.pojo.bpmn.Line;
import main.java.modele.pojo.bpmn.MessageFlow;
import main.java.modele.pojo.bpmn.Pool;
import main.java.modele.pojo.bpmn.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the BPMN's Map 
 *
 */
public class MapBpmnObjectHandlerSax extends DefaultHandler {

	private StringBuilder currentValue = new StringBuilder();
	private List<Pool> result;
	private Pool currentPool;
	private Line currentLine;
	private List<MessageFlow> flows;

	public List<Pool> getResult() {
		return result;
	}
	/**
	 * this method is to create new list of result and flows of bpmn
	 *
	 */
	@Override
	public void startDocument() {
		result = new ArrayList<>();
		flows = new ArrayList<>();
	}
	/**
	 * this method is to attribute each primes in the current pool of the bpmn
	 * @param localame represent bpmn participant
	 * @param qName represent  bpmn process
	 * @param attributes the attributes that does excites
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		// reset the tag value
		currentValue.setLength(0);

		// start of loop
		if (qName.equalsIgnoreCase("bpmn:participant")) {
			// new pool
			currentPool = new Pool();
			currentPool.setId(attributes.getValue("processRef"));
			currentPool.setName(attributes.getValue("name"));
			currentPool.setIdParticipant(attributes.getValue("id"));
		}

		if (qName.equalsIgnoreCase("bpmn:process")) {
			String id = attributes.getValue("id");
			for (Pool pool : result) {
				if (id.equals(pool.getId())) {
					this.currentPool = pool;
				}
			}
		}
		if (qName.equalsIgnoreCase("bpmn:messageFlow")) {
			this.flows.add(new MessageFlow(attributes.getValue("id"), attributes.getValue("sourceRef"),
					attributes.getValue("targetRef")));
		}
		if (qName.contains("task")) {
			Task task = new Task(attributes.getValue("id"));
			this.currentPool.getTasks().add(task);
		}

		if (qName.equalsIgnoreCase("bpmn:intermediateCatchEvent")
				|| qName.equalsIgnoreCase("bpmn:intermediateThrowEvent")) {
			Event event = new Event(attributes.getValue("id"), attributes.getValue("name"));
			this.currentPool.getEvents().add(event);
		}
		if (qName.equalsIgnoreCase("bpmn:lane")) {
			this.currentLine = new Line(attributes.getValue("id"), attributes.getValue("name"));
			this.currentPool.getLines().add(this.currentLine);
		}
	}
	/**
	 * this method is for adding attributes to the current line & the result of bpmn 
	 * @param uri the Namespace URI mapped to the prefix
	 * @param qName represent name of a part in the bpmn
	 * 
	 */

	@Override
	public void endElement(String uri, String localName, String qName) {

		if (qName.equalsIgnoreCase("bpmn:flowNodeRef")) {
			this.currentLine.getEntityBpmns().add(new EntityBpmn(this.currentValue.toString()));
		}
		// end of loop
		if (qName.equalsIgnoreCase("bpmn:participant")) {
			result.add(currentPool);
		}
		if (qName.equalsIgnoreCase("bpmn:definitions")) {
			defineEvent();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		currentValue.append(ch, start, length);

	}
	/**
	 * this method is to define the events in the bpmn
	 * 
	 */
	private void defineEvent() {
		for (MessageFlow messageFlow : flows) {
			String idSource = messageFlow.getSourceRef();
			String idTarget = messageFlow.getTargetRef();
			for (Pool pool : result) {
				if (pool.searchId(idSource)) {
					pool.getSendEvent().add(idSource);
				}
				if (pool.searchId(idTarget)) {
					pool.getReceiveEvent().add(idTarget);
				}
			}
		}
	}
}
