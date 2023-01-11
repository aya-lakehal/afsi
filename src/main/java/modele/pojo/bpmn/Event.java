package main.java.modele.pojo.bpmn;

/**
 * this class represent BPMN's event 
 *
 */
public class Event {

	private String id;
	private String name;
	/**
	 * constructor to create the BPMN's event
	 * @param id the id of the event
	 */
	public Event(String id) {
		this.id = id;
	}
	/**
	 * represent the constructor2 of event
	 * @param value the id of event in the bpmn
	 * @param value2 the name of event in the bpmn
	 */
	public Event(String value, String value2) {
		this.id = value;
		this.name = value2;
	}
	/**
	 * this method is to get the id of the bpmn's event
	 * @return the name of the bpmn's event
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the id of the bpmn's event
	 * @param id of the bpmn's event
	 * @return the id of the bpmn's event
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * this method is to get the name of the bpmn's event
	 * @return  the name of the bpmn's event
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + "]";
	}
	/**
	 * set a new name of the bpmn's event
	 * @param name of the bpmn's event
	 * @return the new name of the bpmn's event
	 */	
	public void setName(String name) {
		this.name = name;
	}

}
