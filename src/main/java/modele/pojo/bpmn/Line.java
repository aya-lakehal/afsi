package main.java.modele.pojo.bpmn;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private String id;
	private String name;
	private List<EntityBpmn> entityBpmns;
	/**
	 * this method represent the constructor of the Line in BPMN
	 */
	public Line(String id, String name) {
		this.id = id;
		this.name = name;
		this.entityBpmns = new ArrayList<>();
	}
	/**
	 * this method is to get the name of the line in the BPMN 
	 * @return the name of the name of the line in the BPMN 
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the new name of the line in the BPMN 
	 * @param name the name of the line in the BPMN 
	 * @return the new name of the name of the line in the BPMN 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * this method is to get the id of the line in the BPMN 
	 * @return the id of the line in the BPMN 
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the new the id of the line in the BPMN 
	 * @param name the id of the line in the BPMN 
	 * @return the new the id of the line in the BPMN 
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Line [id=" + id + ", name=" + name + ", entityBpmns=" + entityBpmns + "]";
	}

	public List<EntityBpmn> getEntityBpmns() {
		return entityBpmns;
	}
	/**
	 * set  new entity of the BPMN 
	 * @param entityBpmns the entity of BPMN

	 */
	public void setEntityBpmns(List<EntityBpmn> entityBpmns) {
		this.entityBpmns = entityBpmns;
	}

}
