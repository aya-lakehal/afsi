package main.java.modele;

import java.util.List;
import java.util.StringJoiner;

import main.java.exception.CategoryNotFound;
import main.java.modele.pojo.bpmn.Bpmn;
import main.java.modele.pojo.bpmn.Event;
import main.java.modele.pojo.bpmn.Line;
import main.java.modele.pojo.bpmn.Pool;
import main.java.modele.pojo.mcf.Actor;
import main.java.modele.pojo.mcf.Arrow;
import main.java.modele.pojo.mcf.Mcf;
import main.java.modele.pojo.mcf.Objective;
/**
 * this class is for purpose to make a comparison between the different models( MCF & MCF)
 *
 */
/**
 * @author etudiant
 *
 */
public class ComparatorModele {

	private Mcf mcf;
	private Bpmn bpmn;
	private List<Fichier> files;
	
	/**
	 * the constructor of list that contains different models
	 * @param files : list of different models
	 *
	 */
	public ComparatorModele(List<Fichier> files) {
		this.files = files;
	}
	
	/**
	 * The method that will make the comparison of different models
	 * @return the result of comparison 
	 */
	public String compare() {
		StringJoiner result = new StringJoiner("\n\n\n");
		try {
			initializeBpmn();
			initializeMcf();
		} catch (CategoryNotFound e) {
			e.printStackTrace();
		}
		String actor = createAnswer(this.compareNameActors());
		String si = createAnswer(this.compareSI());
		String obj = createAnswer(this.compareObjectives());
		String numberOfFlow = createAnswer(this.compareNumberOfFlows());
		String numberActors = createAnswer(this.compareNumberActors());
		String numberObjectives = createAnswer(this.compareNumberObjectives());
		String target = createAnswer(this.compareTargetEvent());
		result.add("Nom des acteurs : " + actor);
		result.add("Nom du systeme d'information : " + si);
		result.add("Nom des acteurs internes/objectifs : "+obj);
		result.add("Nombre de flux : "+numberOfFlow);
		result.add("Nombre d'acteur : "+numberActors);
		result.add("Nombre d'acteur interne/objectif : "+numberObjectives);
		result.add("Liaison des flux : "+target);

		return result.toString();
	}
	/**
	 * a method that analyzes the type of modele's file as an MCF
	 */
	public void initializeMcf() throws CategoryNotFound {
		Fichier file = getFileOfCategory(Category.MCF);
		ParserMcf parserMcf = new ParserMcf();
		parserMcf.parse(file.getPath());
		this.setMcf(parserMcf.getMcf());
	}
	/**
	 * a method that analyzes the type of modele's file as an BPMN
	 */
	public void initializeBpmn() throws CategoryNotFound {
		Fichier file = getFileOfCategory(Category.BPMN);
		ParserBpmn parserBpmn = new ParserBpmn();
		parserBpmn.parse(file.getPath());
		this.setBpmn(parserBpmn.getBpmn());
	}
	/**
	 * The method to get the BPMN
	 * @return bpmn
	 */
	public Bpmn getBpmn() {
		return bpmn;
	}
	/**
	 * The method to set the BPMN
	 * @param bpmn an object which represent a BPMN
	 * @return bpmn
	 */
	public void setBpmn(Bpmn bpmn) {
		this.bpmn = bpmn;
	}
	/**
	 * The method to get the MCF
	 * @return MCF
	 */
	public Mcf getMcf() {
		return mcf;
	}
	/**
	 * The method to set the MCF
	 * @param mcf an object which represent a MCF
	 * @return mcf
	 */
	public void setMcf(Mcf mcf) {
		this.mcf = mcf;
	}
	/**
	 * The method to get the list of file's category
	 * 
	 * @return files that represent a list of different file's category
	 */
	public List<Fichier> getFiles() {
		return files;
	}
	/**
	 * A method to set a file in the list of files
	 * @param files that represent a list of files which represent the different category of files to analyze
	 * 
	 */
	public void setFiles(List<Fichier> files) {
		this.files = files;
	}

	public boolean compareSI() {
		return this.mcf.getName().equalsIgnoreCase(this.bpmn.getMainPool().getName());
	}
	/**
	 * A method to compare actor's name 
	 * @return boolean
	 * if the actor's name  is the same in both files it returns true
	 * and when it's not the same it returns false
	 */
	public boolean compareNameActors() {
		for (Actor actor : this.mcf.getActors()) {
			if (!compareNameOfOneActor(actor)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * A method to compare number of actors in each file
	 * @return boolean
	 * true if they have the same number of actors and false if it's not
	 */
	public boolean compareNumberActors() {
		return this.mcf.getActors().size() == this.bpmn.getPools().size() - 1;
	}
	/**
	 * A method to compare number of objectives in each file
	 * @return boolean
	 * true if they have the same number of objectives of actors and false if it's not
	 */
	public boolean compareNumberObjectives() {
		return this.mcf.getObjectives().size() == this.bpmn.getMainPool().getLines().size();
	}
	/**
	 * A method to compare objectives in each file 
	 * @return boolean
	 * true if they have the same objectives and false if it's not
	 */
	public boolean compareObjectives() {
		for (Objective obj : this.mcf.getObjectives()) {
			if (!compareNameOfOneObjective(obj)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * A method to compare the number of flows 
	 * @return boolean
	 * true if they have the same number of flows and false if it's not
	 */
	public boolean compareNumberOfFlows() {
		return this.mcf.getArrows().size() == this.bpmn.getMainPool().getEvents().size();
	}
	/**
	 * A method to compare names of flows 
	 * @return boolean
	 * true if they have the same names of flows and false if it's not
	 */
	public boolean compareNameOfFlows() {
		for (Arrow arrow : this.mcf.getArrows()) {
			if (!compareNameOfOneFlow(arrow)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * A method to compare the target event 
	 * @return boolean
	 * true if they have the same target events in both models and false if it's not
	 */
	public boolean compareTargetEvent() {
		for (Arrow arrow : this.mcf.getArrows()) {
			if (!compareTargetEventByArrow(arrow)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * A method to get the file's category
	 * @param category represent the category of the file
	 * @return fichier the file that it depends on the category pf file
	 * 
	 */
	private Fichier getFileOfCategory(Category category) throws CategoryNotFound {
		for (Fichier fichier : files) {
			if (category.equals(fichier.getCategory())) {
				return fichier;
			}
		}
		throw new CategoryNotFound();
	}
	/**
	 * The method that compares the target events by arrow
	 * @param arrow the arrow that contain the name of the flow
	 * @return boolean
	 */	
	private boolean compareTargetEventByArrow(Arrow arrow) {
		boolean boolSource = false;
		boolean boolTarget = false;
		String source = this.mcf.getNameOfActorOrObjectiveByid(arrow.getIdSource());
		String target = this.mcf.getNameOfActorOrObjectiveByid(arrow.getIdTarget());
		for (Pool pool : this.bpmn.getPools()) {
			boolSource = compareArrowNameToPoolName(boolSource, source, pool);
			boolTarget = compareArrowNameToPoolName(boolTarget, target, pool);
		}
		return boolSource && boolTarget;
	}
	/**
	 * The method that compares the name of the arrow 
	 * @param boolSource for boolean type
	 * @param source which represent the name of the pool
	 * @param pool the pool tin the bpmn 
	 * @return true if it's the right name  and false if it's not
	 */	
	private boolean compareArrowNameToPoolName(boolean boolSource, String source, Pool pool) {
		if (source.equals(pool.getName())) {
			boolSource = true;
		} else {
			for (Line line : pool.getLines()) {
				if (source.equals(line.getName())) {
					boolSource = true;
				}
			}
		}
		return boolSource;
	}
	/**
	 * The method that compare name flow in the bpmn
	 * @param arrow the arrow that contain the name of the flow
	 * @return true if it's the right name in the bpmn and false if it's not
	 */	
	private boolean compareNameOfOneFlow(Arrow arrow) {
		for (Event event : this.bpmn.getMainPool().getEvents()) {
			if (event.getName().equalsIgnoreCase(arrow.getName())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * The method that compare name actor in the bpmn
	 * @param actor which is in the bpmn
	 * @return true if it's the right name in the bpmn and false if it's not
	 */	
	private boolean compareNameOfOneObjective(Objective obj) {
		for (Pool pool : this.bpmn.getPools()) {
			for (Line line : pool.getLines()) {
				if (line.getName().equalsIgnoreCase(obj.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * The method that compare name actor in the bpmn
	 * @param actor which is in the bpmn
	 * @return true if it's the right name in the bpmn and false if it's not
	 */	
	private boolean compareNameOfOneActor(Actor actor) {
		for (Pool pool : this.bpmn.getPools()) {
			if (pool.getName().equalsIgnoreCase(actor.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The method that create an answer which is valid or error 
	 * @bool bool the boolean type
	 * @return valid if ut's the right boolean or false if it's not 
	 */	
	private String createAnswer(Boolean bool) {
		if(Boolean.TRUE.equals(bool)) {
			return "Valide";
		}
		return "Erreur";
	}
}
