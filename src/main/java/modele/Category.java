package main.java.modele;

/**
 * this class represent the different file's category that we can analyze 
 * there is two : BPMN & MCF
 *
 */
public enum Category {

	BPMN("bpmn"),MCF("mcf");
	
	private final String text;

	/**
	 * @param text
	 */
	Category(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
