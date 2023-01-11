package main.java.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.modele.Project;

public class ExportController {
	
	/** Button to export the project  */
	@FXML
	private Button exportButton;
	

	@FXML
	private ComboBox<String> format;
	

	@FXML
	private Text text;
	
	/** Button to be on home page of the app */
	@FXML
	private Button home;

	private String rapport;
	private List<Project> projects;
	private ObservableList<String> list = FXCollections.observableArrayList(".txt", ".pdf");

	/**
	 *  A method to initialize the an analysis report 
	 */
	public void initialize() {
		format.setItems(list);
		format.setValue(".txt");
		this.text.setText(rapport);
	}
	/**
	 *  A method to to make the report in format txt
	 */
	public ExportController(String txt, List<Project> projects) {
		super();
		this.rapport = txt;
		this.projects = projects;
	}
	/**
	 *  A method to export the analysis report 
	 *  the report will be exported in a file coding with UTF-8
	 */
	public void exportPressed() {
		FileChooser fc = new FileChooser();
		String var1 = "format " + format.getValue();
		String extension = "*" + format.getValue();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(var1, extension));
		File file = fc.showSaveDialog(null);
		if (file != null) {
			try (PrintStream ps = new PrintStream(file,"UTF-8")) {
				ps.println(this.rapport);
				ps.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 *  A method that gives the possibility to click on the button home
	 *  to be able to position on the home's app page
	 */
	public void clickHomeButton() {
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(c -> new AccueilController(projects));
			root = loader.load();
			Stage stage = (Stage) home.getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}