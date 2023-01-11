package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.java.modele.Project;
import main.java.modele.User;
import javafx.collections.*;

/**
 * Base controller for Application homepage
 */
public class AccueilController {
	/** Button to modify a project */
	@FXML
	private Button modifyProjectButton;

	/** Button to create a new project */
	@FXML
	private Button newProjectButton;

	/** Button to delete a project */
	@FXML
	private Button deleteProjectButton;

	/** Button to delete a user account */
	@FXML
	private Button deleteAccountButton;

	/** Button to disconnect */
	@FXML
	private Button deconnexionButton;

	/** Button to see the tutorial of the app */
	@FXML
	private Button buttonTutoriel;

	/** A table to visualize an unlimited number of project */
	@FXML
	protected TableView<Project> tableau;

	/** TableColumn to visualize an unlimited number of project */
	@FXML
	protected TableColumn<Project, String> nameColumn;

	Parent root = null;

	private List<Project> projects;

	private User user;

	public static final String PATH_ACCUEIL = "../../ressources/accueil.fxml";

	/**
	 * A method which the projects are represented in Table to visualize an
	 * unlimited number of project
	 */
	@FXML
	void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setSortType(TableColumn.SortType.DESCENDING);
		tableau.setItems(FXCollections.observableArrayList(this.projects));
	}

	public AccueilController() {
		this.projects = new ArrayList<>();
	}
	public AccueilController(User u) {
		this.user = u;
		this.projects = new ArrayList<>();
	}
	public AccueilController(List<Project> p) {
		this.projects = p;
	}

	public void chooseProjectInTable() {
		Project project = this.tableau.getSelectionModel().getSelectedItem();
		if (project != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/project.fxml"));
				loader.setControllerFactory(c -> new ProjectController(project,this.projects));
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.createStage();
		}

	}

	/**
	 * A Method which create a new project using newProject button
	 */
	public void nouveauProjet() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/newProject.fxml"));
			loader.setControllerFactory(c -> new NewProjectController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}

	/**
	 * A Method to delete a user account using the delete button
	 */
	public void deleteAccount() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/deleteAccountPopUp.fxml"));
			loader.setControllerFactory(c -> new DeleteAccountPopUpController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}

	/**
	 * A Method to disconnect using the disconnect button
	 */
	public void deconnect() {
		if(user != null) {
			user.disconnectUser();
		}
		try {
			root = FXMLLoader.load(getClass().getResource("../../ressources/connexion.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}

	/**
	 * A Method to modifiy using the disconnect button
	 */
	public void goToModify() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/modifyProject.fxml"));
			loader.setControllerFactory(c -> new ModifyController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}

	/**
	 * A Method to delete a project using the deleteProject button
	 */
	public void goToDelete() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/deleteProject.fxml"));
			loader.setControllerFactory(c -> new DeleteProjectController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
	}

	/**
	 * A Method to be able to see the tutorial how to use the app using the button
	 * tutorial
	 */
	public void tutoriel() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/tutoriel.fxml"));
			loader.setControllerFactory(c -> new TutorielController(this.projects));
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.createStage();
		
	}
	
	private void createStage() {
		Stage stage = (Stage) buttonTutoriel.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
