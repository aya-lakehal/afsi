package main.java.modele.pojo.mcf;

import java.util.ArrayList;
import java.util.List;
/**
 * this class represent the model pf MCF
 * @author etudiant
 *
 */
public class Mcf {
	
	private String name;
	private List<Actor> actors;
	private List<Arrow> arrows;
	private List<Objective> objectives;
	/**
	 * the constructor to sreate the MCF
	 */
	public Mcf() {
		this.actors = new ArrayList<>();
		this.arrows = new ArrayList<>();
		this.objectives = new ArrayList<>();

	}
	
	/**
	 * get the actors in the mcf
	 * @return the actors in the mcf
	 */
	public List<Actor> getActors() {
		return actors;
	}
	/**
	 * set the actors in the list of mcf's acotrs 
	 * @param acotrs the list of actors in the mcf
	 */
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	/**
	 * get the arrows of mcf
	 * @return mcf's arrows
	 */
	public List<Arrow> getArrows() {
		return arrows;
	}
	/**
	 * set the arrows in the list of mcf's arrows
	 * @param arrows the list  of mcf's arrows
	 */
	public void setArrows(List<Arrow> arrows) {
		this.arrows = arrows;
	}
	/**
	 * get the name on the mcf 
	 * @return the new name of mcf
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name on the mcf 
	 * @param name of mcf
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the list of objectives in the mcf
	 * @return objectives the list of objectives in the mcf
	 */
	public List<Objective> getObjectives() {
		return objectives;
	}
	/**
	 * set objectives in the list of objectives of he mcf
	 * @param objectives of mcf
	 */
	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	@Override
	public String toString() {
		return "Mcf [name=" + name + ", actors=" + actors + ", arrows=" + arrows + ", objectives=" + objectives + "]";
	}
	/**
	 * this method is to get the name of actors or objectives using the id of mcf 
	 * @param id the id of mcf
	 * @return the name of actors or objectives using the id of mcf 
	 */
	public String getNameOfActorOrObjectiveByid(String id) {
		for (Actor actor : actors) {
			if (id.equals(actor.getId())) {
				return actor.getName();
			}
		}
		for (Objective obj : this.objectives) {
			if(id.equals(obj.getId())) {
				return obj.getName();
			}
		}
		return null;
	}
	
}
