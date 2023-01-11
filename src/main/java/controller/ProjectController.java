package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.java.modele.Category;
import main.java.modele.ComparatorModele;
import main.java.modele.Fichier;
import main.java.modele.ImportFile;
import main.java.modele.Project;
/**
 * this class is for the controller project
 *
 */
public class ProjectController {

	@FXML
	private Label nameFile1;
	@FXML
	private Label nameFile2;
	@FXML
	private Label projectName;
	@FXML
	private ChoiceBox<Category> fileCategory;
	@FXML
	private Button importButton;
	@FXML
	private Button startButton;
	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;
	@FXML
	private TableView<Fichier> fileTable;
	@FXML
	private TableColumn<Fichier, String> column;
	@FXML
	private Button backButton;
	@FXML
	private Button resetFilter;

	private Project project;

	private static final int NUMBER_FILES_COMPARATOR = 2;
	private int indexFileChoose = 0;

	private List<Fichier> choosenFiles = new ArrayList<>();
	private List<Project> projects;
	
	/**
	 * this method is for initializing  the value, the name and the category of project in order to controll it
	 */
	@FXML
	void initialize() {
		column.setCellValueFactory(new PropertyValueFactory<>("name"));
		column.setSortType(TableColumn.SortType.DESCENDING);
		fileCategory.setItems(FXCollections.observableArrayList(Category.values()));
		this.loadAllFiles();
	}
	
	/**
	 * this method is the constructor to create a project controller 
	 * @param project the user's project
	 * @param projects the list of projects 
	 */
	public ProjectController(Project project,List<Project> projects) {
		this.project = project;
		this.projects = projects;
	}
	
	/**
	 * this method is for loading a file by getting the file of the project
	 */
	public void loadAllFiles() {
		List<Fichier> listOfFile = project.getFiles();
		fileTable.setItems(FXCollections.observableArrayList(listOfFile));
	}
	
	/**
	 * this method is for importing a file 
	 */
	public void importFile() {
		try {
			ImportFile imp = new ImportFile();
			imp.chooseFile();
			Fichier file = imp.getFichier();
			if (file != null) {
				this.project.addFile(file);
				this.resetFilterCategory();
				this.loadAllFiles();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void back() {
		this.loadHomePage();
	}
	
	public void resetFilterCategory() {
		this.fileCategory.valueProperty().set(null);
		this.resetFilter.setOpacity(0);
	}
	/**
	 * this method is for selecting the chosen file that will be analyzed 
	 */
	public void chooseFileInTable() {
		Fichier file = this.fileTable.getSelectionModel().getSelectedItem();
		if (file != null) {
			int index = indexFileChoose % NUMBER_FILES_COMPARATOR;
			this.choosenFiles.add(index, file);
			indexFileChoose++;

			if (index == 0) {
				this.nameFile1.setText(file.getName());
			} else {
				this.nameFile2.setText(file.getName());
			}
		}
	}
	
	/**
	 * this method is for make the analyze and checking the files in the project 
	 * by comparing both of models 
	 */
	public void launchAnalyse() {
		if (this.choosenFiles.size() >= NUMBER_FILES_COMPARATOR && isMcfAndBpmnModel(this.choosenFiles)) {
			ComparatorModele comparatorModele = new ComparatorModele(choosenFiles);
			String txt = comparatorModele.compare();

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../ressources/export.fxml"));
				loader.setControllerFactory(c -> new ExportController(txt,projects));

				Parent root = loader.load();
				Stage stage = (Stage) this.startButton.getScene().getWindow();
				stage.setScene(new Scene(root));
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * this method is to choose the category of the file  in the list of files 
	 */
	public void clickOnCategory() {
		Category category = fileCategory.getSelectionModel().getSelectedItem();
		List<Fichier> resultFiles = this.project.getFilesByCategory(category);
		if (!resultFiles.isEmpty()) {
			List<Fichier> fichier = project.getFilesByCategory(category);
			fileTable.setItems(FXCollections.observableArrayList(fichier));
		} else {
			fileTable.setItems(FXCollections.observableArrayList());
		}
		this.resetFilter.setOpacity(1);
	}
	/**
	 * this method check if the files that have inserted is an mcf or bpmn file
	 * @param files list of files in the project 
	 * @return true if the file is bpmn or mcf file and false if it's not 
	 */
	private boolean isMcfAndBpmnModel(List<Fichier> files) {
		return !files.get(0).getCategory().equals(files.get(1).getCategory());
	}
	/**
	 * this method is for loading home age of the app
	 */
	private void loadHomePage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(AccueilController.PATH_ACCUEIL));
			loader.setControllerFactory(controller -> new AccueilController(projects));
			Parent root = loader.load();
			Stage stage = (Stage) backButton.getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
