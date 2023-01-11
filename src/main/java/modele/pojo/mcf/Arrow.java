package main.java.modele.pojo.mcf;
/**
 * this class represent the arrow in the mcf
 *
 */
public class Arrow {

	private String id;
	private String name;
	private String idSource;
	private String idTarget;
	
	/**
	 * the constructor of the mcf's arrow
	 * @param id the id of the arrow
	 * @param name the name of the arrow
	 * @param idSource the id source of the arrow
	 * @param idTarget the id target of the arrow
	 */
	public Arrow(String id, String name, String idSource, String idTarget) {
		this.id = id;
		this.name = name;
		this.idSource = idSource;
		this.idTarget = idTarget;
	}

	@Override
	public String toString() {
		return "Arrow [id=" + id + ", name=" + name + ", idSource=" + idSource + ", idTarget=" + idTarget + "]";
	}
	
	/**
	 * get the id of the arrow
	 * @return the id of the arrow
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the id of the arrow
	 * @param id the id of the arrow
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * get the name of the arrow
	 * @return the name of the arrow
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name the arrow
	 * @param name of the arrow 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the id source of the arrow
	 * @return the id source of the arrow
	 */
	public String getIdSource() {
		return idSource;
	}
	
	/**
	 * set the new id source of the arrow
	 * @param idSource  
	 */
	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}

	public String getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(String idTarget) {
		this.idTarget = idTarget;
	}

}
