package main.java.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import main.java.modele.Project;
/**
 * this class is for creating a controller for a new project 
 *
 */
public class NewProjectController {
	
	/** the button to back to homepage of the app */
	@FXML
	private Button backButton;
	
	@FXML
	private Button ok;
	
	/** the area where the user put the description of the project */
	@FXML
	private TextArea descriptionProjet;
	
	/** the area where the user put the name of the project */
	@FXML
	private TextField nomProjet;

	private List<Project> projects;
	private static final int LIMIT_NUMBER_PROJECT = 5;
	/**
	 * the constructor to create the controller of new project
	 * @param projects represent the lists of user's projects 
	 */
	public NewProjectController(List<Project> projects) {
		this.projects = projects;
	}
	
	/**
	 * this method is used to create project 
	 * when the user want to create a project the number is limited 
	 * 
	 */
	public void createProject() {
		Alert alert = new Alert(AlertType.NONE,"",ButtonType.OK);
		alert.setTitle("D�passement limite projet");
		alert.setContentText("La cr�ation de projet est limit�e � 5");
		String name = this.nomProjet.getText().replaceAll("[^A-Za-z0-9]", "");
		if (!name.isBlank()) {
			String description = this.descriptionProjet.getText();
			Project p = new Project(name, description);
			if (this.projects.size() < LIMIT_NUMBER_PROJECT) {
				projects.add(p);
				alert.setAlertType(AlertType.INFORMATION);
			} else {
				alert.setAlertType(AlertType.ERROR);
			}
			alert.showAndWait();

		}
		this.loadHomePage();

	}
	/**
	 * this method helps the user to back to homepage
	 */
	public void back() {
		this.loadHomePage();
	}
	
	/**
	 * this method is for loading the home page u
	 * sing the path of home page of the app
	 */
	private void loadHomePage() {
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) nomProjet.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
