package main.java.modele;

import java.io.File;

public class Fichier {
	
	private File file;
	private String name;
	private Category category;
	
	public Fichier(String name, Category category, File f) {
		this.file = f ;
		this.name = name;
		this.category = category;
	}
	

	public Fichier(String name, Category category) {
		this.name = name;
		this.category = category;
	}
	
	public File getFile() {
		return this.file ;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFile(File f) {
		this.file = f;
	}


	@Override
	public String toString() {
		return name;
	}


	public String getPath() {
		return this.file.getPath();
	}
	
}
