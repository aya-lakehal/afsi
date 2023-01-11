package main.java.modele.pojo.bpmn;

/**
 * this class represent the task of bpmn file
 *
 */
public class Task {

	private String id;
	/**
	 * the constructor of bpmn's task
	 * @param id the id of task 
	 */
	public Task(String id) {
		this.id = id;
	}
	/**
	 * get the id of task
	 * @return id of task
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the new id to task
	 * @param id represent the new id that will be set to task
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + "]";
	}
}
