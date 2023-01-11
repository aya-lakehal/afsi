package main.java.modele;

/**
 * this class represent a project by his name & category
 *
 */
public class ElementTable {

	private String name;
	private Project project;
	private Category category;
	
	/**
	 *this method represent the constructor of the class
	 *@param project the project that the user work on
	 *@param category the category of the project that the user work on
	 */
	public ElementTable(Project project, Category category) {
		this.name = project.getName();
		this.category = category;
		this.project = project;
	}
	/**
	 *get the name of project 
	 *@return the name of project
	 */
	public String getName() {
		return name;
	}
	/**
	 *set the name of project 
	 *@return the name of project
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *set the project 
	 *@return project
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 *get the  project 
	 *@return  project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 *get the category of project 
	 *@return the category of project
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 *set the category of project 
	 *@return the category of project
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
