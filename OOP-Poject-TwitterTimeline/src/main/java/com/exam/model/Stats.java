package com.exam.model;
/**
 * Classe padre che contiene una mappa,
 * le quali figlie andranno ad ereditare come nuovo tipo.
 * 
 * @author Camilla D'Andrea
 * @author Federica Ripani
 */
import java.util.Map;

public class Stats {
	private Map<String, Object> M;
	
	public Stats(Map<String, Object> map) {
		this.setM(map);
		
	}
	
	public Stats() {
	}

	public Map<String, Object> getM() {
		return M;
	}

	public void setM(Map<String, Object> m) {
		M = m;
	}

}
