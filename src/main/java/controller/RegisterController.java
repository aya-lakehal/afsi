package main.java.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * this class is for register controller
 * it helps the user to click on backbutton and register button
 * and show a text if the password field  or confirmed for the user 
 *
 */
public class RegisterController {

	@FXML
	private Button backButton;
	@FXML
	private Button registerButton;
	@FXML
	private TextField loginField;
	@FXML
	private TextField pwdField;
	@FXML
	private TextField pwdConfirmField;
	@FXML
	private Button backPopUpButton;
	
	private boolean valid = false;
	
	/**
	 * this method is for the back controller
	 * it helps the user to back to page before in the app
	 */
	public void back() {	
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass()
			        .getResource("../../ressources/connexion.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	/**
	 * this method make the user capable to register the event 
	 * @param event the action event 
	 * @throws IOException 
	 */
	public void register(ActionEvent event) throws IOException {
		Parent root = null;
		Stage stage;
		if (event.getSource() == this.registerButton) {
			if(valid) {
				root = FXMLLoader.load(getClass().getResource("../../ressources/registerPopup.fxml"));
			}
			else {
				root = FXMLLoader.load(getClass().getResource("../../ressources/registerPopupError.fxml"));
			}
		stage = new Stage();
		stage.setScene(new Scene(root));
		
		/* just this stage can click by user */
		stage.initModality(Modality.APPLICATION_MODAL);
		
		/* Impossible to change the size */
		stage.setResizable(false);
		
		stage.initOwner(this.loginField.getScene().getWindow());
				
		stage.showAndWait();
		}
		else {
			stage = (Stage) this.backPopUpButton.getScene().getWindow();
			stage.close();
		}
	}
}
