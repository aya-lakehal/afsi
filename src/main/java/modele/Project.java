package main.java.modele;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String name;
	private String description;
	private List<Fichier> fichiers;

	public Project(String name, String descString) {
		this.setName(name);
		this.setDescription(descString);
		this.setFiles(new ArrayList<>());
	}
	/**
	 * this method is to get the name of project
	 * @return the name of the project
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of project
	 * @param name represent the name of the project 
	 * @return the new name of the project 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * this method is to get the description of project
	 * @return the description of the project
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * set the description of project
	 * @param description represent the description of the project 
	 * @return the new description of the project 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * this method is to get the list that contains files who represent the project
	 * @return the list that contains files who represent the project
	 */
	public List<Fichier> getFiles() {
		return fichiers;
	}
	/**
	 * set files in to the list that contains files who represent the project
	 * @return files that represent files in the project
	 */
	public void setFiles(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	/**
	 * this method is to add the list that contains files who represent the project
	 * @param f the file that will be added 
	 */
	public void addFile(Fichier f) {
		this.fichiers.add(f);
	}
	/**
	 * this method returns true if the files are empty and false if it's not
	 *
	 */
	public boolean isEmpty() {
		return this.fichiers.isEmpty();
	}
	/**
	 * this method is to add  the list a files which has the category that correspond to the file
	 * @return the list that contains files by their categories 
	 */
	public List<Fichier> getFilesByCategory(Category category) {
		List<Fichier> liste = new ArrayList<>();
		for (Fichier f : this.fichiers) {
			if (f.getCategory().equals(category))
				liste.add(f);
		}
		return liste;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
