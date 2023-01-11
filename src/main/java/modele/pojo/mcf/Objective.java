package main.java.modele.pojo.mcf;

/**
 * this class represent the objectives in the mcf model 
 *
 */
public class Objective {

	private String id;
	private String name;
	
	/**
	 * the constructor of the class to create the objective of an mcf
	 * @param id the id of mcf
	 * @param name the name of mcf
	 */
	public Objective(String id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * get the id of mcf
	 * @return the id of mcf
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the id of mcf
	 * @param id the new id that will be setting 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get the name of the mcf 
	 * @return the name of mcf
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of the mcf 
	 * @param name the name of mcf
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Objective [id=" + id + ", name=" + name + "]";
	}
}
