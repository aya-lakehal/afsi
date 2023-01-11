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
import javafx.collections.*;
import javafx.stage.Stage;
import main.java.modele.Project;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
/**
 *  A class to delete delete a project
 */
public class DeleteProjectController {
	
	/** Button that make the user be able to come back to the previous page*/
	@FXML
	private Button back;
	
	/** Button to delete the project  */
	@FXML
	private Button deleteProjectButton;
	
	/** Text that show which project we want to select */
	@FXML
	private Text selectedProject;
	
	/** make which project to choose */
	@FXML
	private ChoiceBox<Project> projecteDeleterChoiceBox;
	
	/** a list that represent all projects that have been created  */
	private List<Project> projects;

	@FXML
	void initialize() {

		projecteDeleterChoiceBox.setItems(FXCollections.observableArrayList(projects));
	}
	
	/**
	 *  A method to delete a project 
	 */
	public DeleteProjectController(List<Project> projects) {
		this.projects = projects;
	}
	/**
	 *  A method which we can choose the project 
	 *  by his value and the name of project
	 */
	public void choice() {
		if (this.projecteDeleterChoiceBox.getValue() != null) {
			selectedProject.setText(projecteDeleterChoiceBox.getValue().getName());
		}
	}
	/**
	 *  A method to delete project which has been chosen in the box
	 */
	public void deleteProject() {
		Project project = this.projecteDeleterChoiceBox.getValue();
		if (project != null) {
			this.projects.remove(project);
			Alert message = new Alert(AlertType.CONFIRMATION,"",ButtonType.OK);
			message.setTitle("Suppression de projet");
			message.setContentText("Projet " + project +" a bien �t� supprim�");
			message.showAndWait();
		}
		this.loadHomePage();
	}
	/**
	 *  A method which make the user came back to the home page
	 */
	public void back() {
		this.loadHomePage();
	}
	/**
	 *  A method to load home page
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
		Stage stage = (Stage) deleteProjectButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
