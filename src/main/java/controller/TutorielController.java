package main.java.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.modele.GeneratorTutorialString;
import main.java.modele.Project;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
/**
 * this class was made for purpose to help the user 
 * in order to gives him information about using the app
 */
public class TutorielController {
	@FXML
	private Button backButton;

	@FXML
	private Button fonctionnelButton;

	@FXML
	private Button applicationButton;

	@FXML
	private Text textTutorielApplication;
	
	@FXML
	private Text textTutorielFonctionnel;

	private List<Project> projects;

	private static final String PATH_TUTORIAL_FONCTIONNEL = "../../ressources/conseilFonctionnel.fxml";
	private static final String PATH_TUTORIAL_APPLICATION = "../../ressources/controlApplication.fxml";
	
	/**
	 * this method is for the tutorial controller 
	 * @param projects the projects of the user
	 */


	@FXML
	public void initialize() {
		if (this.textTutorielApplication != null) {
			this.textTutorielApplication.setText(GeneratorTutorialString.TUTORIAL_APPLICATION);
		}		
		if (this.textTutorielFonctionnel != null) {
			this.textTutorielFonctionnel.setText(GeneratorTutorialString.TUTORIAL_FONCTIONNEL);
		}
		
	}
	

	public TutorielController(List<Project> projects) {
		this.projects = projects;

	}
	
	/**
	 * this method helps the user to be back on the home page 
	 */
	@FXML
	public void backToAccueil() {
		Parent root = null;

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	/**
	 * this method is to for the path tutorial  function 
	 */
	@FXML
	public void goToFunction() {
		this.makeStageTutorial(PATH_TUTORIAL_FONCTIONNEL);
	}
	
	/**
	 * this method is to for the path application 
	 */
	@FXML
	public void goToApplication() {
		this.makeStageTutorial(PATH_TUTORIAL_APPLICATION);
	}
	/**
	 * this method is for to make a stage tutorial by using the path 
	 * @param path the path of tutorial 
	 */
	private void makeStageTutorial(String path) {
		Parent root = null;

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			loader.setControllerFactory(c -> new TutorielController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) applicationButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

}
