package main.java.controller;

import java.io.IOException;
import java.util.List;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import main.java.modele.Project;

/**
 * this class is for to modify the controller 
 *
 */
public class ModifyController {
	@FXML
	private Button validateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private TextField nameField;
	@FXML
	private TextArea descriptionField;

	@FXML
	private ChoiceBox<Project> projectChoiceBox;
	
	private List<Project> projects;

	@FXML
	void initialize() {
		projectChoiceBox.setItems(FXCollections.observableArrayList(projects));
	}
	/**
	 * the constructor to create the modify controller 
	 * @param projects list of user's projects
	 */
	public ModifyController(List<Project> projects) {
		this.projects = projects;
	}
	
	/**
	 * this method is for to modify a project
	 *  and to modify this project's name and the description
	 */
	public void modify() {
		if (this.projectChoiceBox.getValue() != null) {
			Project selectProject = this.projectChoiceBox.getValue();
			if (!this.nameField.getText().isBlank()) {
				selectProject.setName(this.nameField.getText().replaceAll("[^A-Za-z0-9]", ""));
			}
			if (!this.descriptionField.getText().isBlank()) {
				selectProject.setDescription(this.descriptionField.getText());
			}
		}
		this.loadHomePage();

	}

	public void cancel() {
		this.loadHomePage();
	}

	private void loadHomePage() {
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
