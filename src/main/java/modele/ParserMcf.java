package main.java.modele;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import main.java.modele.pojo.mcf.Actor;
import main.java.modele.pojo.mcf.Arrow;
import main.java.modele.pojo.mcf.Mcf;
import main.java.modele.pojo.mcf.Objective;

/**
 * this class represent the parser of mcf
 *
 */
public class ParserMcf {

	private Mcf mcf;
	/**
	 * the constructor of the mcf parser
	 */
	public ParserMcf() {
		mcf = new Mcf();
	}
	/**
	 * this method if for creating parser 
	 * @param path represent the path that we gives to create the parser 
	 */
	public void parse(String path) {

		try (CSVReader reader = new CSVReader(new FileReader(path))) {
			List<String[]> result = reader.readAll();
			result.forEach(this::parseMcf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method if for creating parser for the mcf
	 * @param row represent the row in the mcf
	 */
	public void parseMcf(String[] row) {
		String id = row[0];
		String type = row[1];
		String name = row[11];
		switch(type) {
		case "Conteneur rectangulaire" : 
			this.mcf.setName(name);
			break;
		case "Acteur" : 
			Actor actor = new Actor(id, name);
			this.mcf.getActors().add(actor);
			break;
		case "Cas d'utilisation" : 
			Objective objective = new Objective(id, name);
			this.mcf.getObjectives().add(objective);
			break;
		case "Ligne" : 
			String idSource = row[6];
			String idTarget = row[7];
			Arrow arrow = new Arrow(id, name,idSource,idTarget);
			this.mcf.getArrows().add(arrow);
			break;
		default : 
			break;
		}
	}
	/**
	 * this method if to get the mcf
	 * @return mcf
	 */
	public Mcf getMcf() {
		return mcf;
	}
	/**
	 * set the mcf
	 * @param mcf
	 * @return mcf
	 */
	public void setMcf(Mcf mcf) {
		this.mcf = mcf;
	}
}
