package main.java.modele.pojo.bpmn;

import java.util.ArrayList;
import java.util.List;
/**
 * this class represent the pool of the bpmn
 * 
 */
public class Pool {

	private String id;
	private String idParticipant;
	private String name;
	private List<Task> tasks;
	private List<Event> events;
	private List<Line> lines;
	private List<String> receiveEvent;
	private List<String> sendEvent;
	
	/**
	 * the constructor of BPMN's pool
	 */
	public Pool() {
		/* For mapping */
		this.tasks = new ArrayList<>();
		this.events = new ArrayList<>();
		this.lines = new ArrayList<>();
		this.receiveEvent = new ArrayList<>();
		this.sendEvent = new ArrayList<>();
	}
	/**
	 * a method to get the name of the BPMN's pool
	 * @return the BPMN's pool
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *set the name of the BPMN's pool
	 * @param name of the BPMN's pool
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the list of tasks of the bpmn
	 * @return the list of tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}
	/**
	 * set the tasks in the list of bpmn's tasks
	 * @param tasks the bpmn'sz tasks
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	/**
	 * get the events of the bpmn 
	 * @return list of the event of bpmn
	 */
	public List<Event> getEvents() {
		return events;
	}
	
	/**
	 * set the events on the list of events
	 * @param events new events to set of bpmn 
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	/**
	 * get the list of lines of bpmn
	 * @return the list of lines of bpmn
	 */
	public List<Line> getLines() {
		return lines;
	}
	
	/**
	 * set the lines in the list of lines of bpmn
	 * @param lines the lines  in the list of lines of bpmn
	 */
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pool [name=" + name + ", events=" + getNameEvents() + ", lines=" + lines + "List Re�ois de flux"
				+ this.getReceiveEvent().toString() + "List envoie de flux" + this.getSendEvent().toString() + "]";
	}
	/**
	 * this method is for looking of the id of pool of bpmn
	 * @param id the id of pool of bpmn
	 * @return true if the id was found and false if it's not
	 */
	public boolean searchId(String id) {
		boolean result = false;
		result = this.idParticipant.equals(id);
		if (!result) {
			result = searchIdInEvent(id);
		}
		if (!result) {
			result = searchIdInTask(id);
		}
		return result;
	}
	/**
	 * this method is for looking of the id in the event of bpmn
	 * @param id the id of event 
	 * @return true if the id was find & false if it's not
	 */
	public boolean searchIdInEvent(String id) {
		for (Event event : events) {
			if (event.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this method is for looking of the id of task 
	 * @param id the id of task
	 * @return true if the id was found and false if it's not 
	 */
	public boolean searchIdInTask(String id) {
		for (Task task : tasks) {
			if (task.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public List<String> getSendEvent() {
		return sendEvent;
	}

	public void setSendEvent(List<String> sendEvent) {
		this.sendEvent = sendEvent;
	}

	public List<String> getReceiveEvent() {
		return receiveEvent;
	}

	public void setReceiveEvent(List<String> receiveEvent) {
		this.receiveEvent = receiveEvent;
	}

	public boolean isMain() {
		return !this.tasks.isEmpty();
	}
	/**
	 * this method is to get the id of participants 
	 * @return the id of participant 
	 */
	public String getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(String idParticipant) {
		this.idParticipant = idParticipant;
	}
	/**
	 * get the name of events in the bpmn 
	 * @return the list that contains the events of bpmn 
	 */
	private List<String> getNameEvents() {
		List<String> result = new ArrayList<>();
		for (Event event : events) {
			result.add(event.getName());
		}
		return result;
	}
}
