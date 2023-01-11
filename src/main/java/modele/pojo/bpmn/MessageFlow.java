package main.java.modele.pojo.bpmn;

/**
 * this class represent the flow in the bpmn 
 *
 */
public class MessageFlow {

	private String id;
	private String sourceRef;
	private String targetRef;
	
	/**
	 * this method represent the message flow in the bpmn 
	 * @param id the message flow
	 * @param sourceRef the source references message flow
	 * @param targetRef the target references message flow
	 */
	public MessageFlow(String id, String sourceRef, String targetRef) {
		this.id = id;
		this.sourceRef = sourceRef;
		this.targetRef = targetRef;
	}
	/**
	 * this method is to get the id of  message flow of BPMN
	 * @return the new id of  message flow of BPMN
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the id of  message flow of BPMN
	 * @return the new id of  message flow of BPMN
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * this method is to get  source Reference in message flow of BPMN
	 * @return the  source Reference in message flow of BPMN
	 */
	public String getSourceRef() {
		return sourceRef;
	}
	/**
	 * set the source Reference in message flow of BPMN
	 * @param the source Reference in message flow of BPMN
	 * @return the new source Reference in message flow of BPMN
	 */
	public void setSourceRef(String sourceRef) {
		this.sourceRef = sourceRef;
	}
	/**
	 * this method is to get  Target Reference in message flow of BPMN
	 * @return  the Target Reference in message flow of BPMN
	 */
	public String getTargetRef() {
		return targetRef;
	}
	/**
	 * set the Target Reference in message flow of BPMN
	 * @param targetRef the Target Reference in message flow of BPMN
	 * @return the new the Target Reference in message flow of BPMN
	 */
	public void setTargetRef(String targetRef) {
		this.targetRef = targetRef;
	}

	@Override
	public String toString() {
		return "MessageFlow [id=" + id + ", sourceRef=" + sourceRef + ", targetRef=" + targetRef + "]";
	}

}
