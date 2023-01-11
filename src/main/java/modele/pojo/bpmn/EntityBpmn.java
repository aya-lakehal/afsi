package main.java.modele.pojo.bpmn;

/**
 * this class represent the entity in the BPMN
 *
 */
public class EntityBpmn {

	private String id;
	/**
	 * the constructor of the the entity in the BPMN
	 * @param id of the entity
	 */
	public EntityBpmn(String id) {
		this.id = id;
	}
	/**
	 * get the id of the entity
	 * @return id of entity
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the new id of entity
	 * @param id of entity
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EntityBpmn [id=" + id + "]";
	}

}
