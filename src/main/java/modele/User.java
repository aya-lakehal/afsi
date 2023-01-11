package main.java.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * calss that represent the user of the app
 *
 */
public class User {

	private String login;
	private List<Project> projects;
	private Connexion connexion;
	/**
	 * this method represent the constructor of user
	 * without parameters 
	 */
	public User() {
		connexion = new Connexion();
	}
	/**
	 * this method represent the constructor of user by using his login
	 * @param login the login of the app's user
	 */
	public User(String login) {
		this.login = login;
		this.projects = new ArrayList<>();
	}
	/**
	 * set the login of app's user
	 * @param login the login of the app's user
	 * @return the new login of the app's user that have been setting
	 */	
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * set projects in the list of user's projects
	 * @param projects represent the list of the projects that the user want to add
	 */	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	/**
	 * this method is to get the login of app's user
	 * @return login of the user
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * add a project to the list of user's projects
	 * @param project the project that will be added to the list of projects 
	 */	
	public void add(Project project) {
		this.projects.add(project);

	}
	/**
	 * this method is to get the set of user's projects
	 * @return user's projects
	 */	
	public List<Project> getProjects() {
		return projects;
	}
	/**
	 * get the connexion of the user
	 * @param onnexion
	 */			
	public Connexion getConnexion() {
		return connexion;
	}
	/**
	 * set the connexion of the user
	 * @param onnexion
	 * @return the new connexion 
	 */	
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}
	
	/**
	 * returns true if the user is connected and false if ot's not 
	 */
	public boolean isConnected() {
		return this.connexion.isConnected();
	}
	/**
	 * disconnect the user in the app 
	 */
	public void disconnectUser() {
		this.connexion.logout();
	}
}
