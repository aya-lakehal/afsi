package main.java.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.exception.IncorrectAuthentification;
import main.java.modele.User;

/**
 * A class to control the connexion of application's users
 *
 */
public class ConnexionController {
	
	/** Button subscribe in the app */
	@FXML
	private Button inscriptionButton;
	
	/** Button to sign in  */
	@FXML
	private Button connexionButton;
	
	/** A text who represent the login username  */
	@FXML
	private TextField loginField;
	
	/** A text who represent the user's passeword */
	@FXML
	private TextField pwdField;

	Parent root = null;
	
	User user;
	
	public ConnexionController() {
		user = new User();
	}
	
	/**
	 * A method that make app's user to connect if they are not already connected 
	 * by using loginFiled which is user's login
	 * and pwdFild for the user's password
	 */
	public void connect() throws IncorrectAuthentification {
		if (this.loginField.getText().isEmpty() || this.pwdField.getText().isEmpty()) {
			throw new IncorrectAuthentification();
		}
		try {
			user.getConnexion().authentification(this.loginField.getText(), this.pwdField.getText());
		} catch (IncorrectAuthentification e) {
			e.printStackTrace();
		}
		if(user.isConnected()) {
			this.loadHomePage();
		}
	}
	
	private void loadHomePage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(user));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) inscriptionButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
	/**
	 * A method that make the user able to subscribe wich the password confirmation field is present. 
	 * @param sceneRoot the password confirmation field
	 */
	private void createScene(String sceneRoot) {
		try {
			root = FXMLLoader.load(getClass().getResource(sceneRoot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) inscriptionButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();

	}
	
	public void inscription() {
		this.createScene("../../ressources/register.fxml");
	}
}