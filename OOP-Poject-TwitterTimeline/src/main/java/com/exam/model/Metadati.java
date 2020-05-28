package com.exam.model;

/** E' la classe base che ci permette di definire come è
 * composto un metadato, ovvero nome assegnato, sua descrizione e tipo di dato
 * @author Camilla D'Andrea
 */

public class Metadati {
	private String name; 
	private String sourceField; 
	private String type; 
	
	public Metadati(String name, String sourceField, String type) {
		this.name = name;
		this.sourceField = sourceField;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	
	
	

}