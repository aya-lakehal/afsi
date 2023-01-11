package main.java.modele.pojo.mcf;

/**
 * this class represent the main actor in the mcf
 *
 */
public class Actor {

	private String id;
	private String name;
	
	/**
	 * the constructor to create the the actor in the mcf
	 * @param id the id of the actor 
	 * @param name the name of actor
	 */
	public Actor(String id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * get the id of the actor
	 * @return the id of the actor
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * set the id of the actor 
	 * @param id the id of the actor 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get the name of the actor
	 * @return the name of the actor
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of the actor 
	 * @param name the id of the actor 
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actors [id=" + id + ", name=" + name + "]";
	}

}
