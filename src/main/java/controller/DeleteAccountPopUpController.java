package main.java.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.modele.Project;

/**
 *  A class to delete an account button controller 
 */
public class DeleteAccountPopUpController {
	
	/** Button for Yes */
	@FXML
	private Button oui;
	
	/** Button for No */
	@FXML
	private Button non;

	Parent root = null;

	private List<Project> projects;
	/**
	 * A controller method to ask for password to register
	 *
	 */
	public DeleteAccountPopUpController(List<Project> projects) {
		this.projects = projects;
	}
	public void askPassword() {
		try {
			root = FXMLLoader.load(getClass().getResource("../../ressources/register.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();

	}
	/**
	 * A controller method to help the user to back to app home with non butthon 
	 * 
	 */
	public void retourAcceuil() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}
	private void createStage() {
		Stage stage = (Stage) non.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

}
