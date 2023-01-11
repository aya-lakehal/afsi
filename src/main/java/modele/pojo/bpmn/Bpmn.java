package main.java.modele.pojo.bpmn;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the bpmn 
 *
 */
public class Bpmn {

	private List<Pool> pools;
	/**
	 * the constructor of bpmn
	 */
	public Bpmn() {
		this.pools = new ArrayList<>();
	}
	
	/**
	 * the constructor of bpmn 
	 * @param result list of Pool 
	 */
	public Bpmn(List<Pool> result) {
		this.pools = result;
	}

	@Override
	public String toString() {
		return "Bpmn [pools=" + pools + "]";
	}
	/**
	 * get the list of Pool 
	 * @return list of bpmn's pool
	 */
	public List<Pool> getPools() {
		return pools;
	}
	/**
	 * set the list of Pool 
	 * @param ppols represent Pools that will be added in the list of Pool 
	 */
	public void setPools(List<Pool> pools) {
		this.pools = pools;
	}

	public Pool getMainPool() {
		for (Pool pool : pools) {
			if (pool.isMain()) {
				return pool;
			}
		}
		return null;
	}

}
