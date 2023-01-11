package main.java.modele;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;

public class ImportFile {

	private Fichier file;
	private static final List<String> EXTENSIONS_SUPPORTED = List.of(".bpmn", ".csv");

	public ImportFile() {
		this.setFichier(null);
	}

	public void chooseFile() {
		File fileChoosen = null;
		boolean isSupported = false;
		while (!isSupported) {
			FileChooser fc = new FileChooser();
			fileChoosen = fc.showOpenDialog(null);
			if (fileChoosen != null) {
				String nameFile = fileChoosen.getName();
				String extensionName = nameFile.substring(nameFile.lastIndexOf('.')).toLowerCase();
				if (EXTENSIONS_SUPPORTED.contains(extensionName)) {
					isSupported = true;
					Category category = Category.BPMN.toString().equals(extensionName.substring(1)) ? Category.BPMN : Category.MCF;
					this.file = new Fichier(getNameFileWithoutExtension(fileChoosen), category, fileChoosen);
				}
			} else {
				/* Any file. The user click on the red cross */
				break;
			}
		}
	}

	public String getNameFileWithoutExtension(File file) {
		String name = file.getName();
		int dotIndex = name.lastIndexOf('.');
		return (dotIndex == -1) ? name : name.substring(0, dotIndex);
	}

	public Fichier getFichier() {
		return file;
	}

	public void setFichier(Fichier file) {
		this.file = file;
	}
}
