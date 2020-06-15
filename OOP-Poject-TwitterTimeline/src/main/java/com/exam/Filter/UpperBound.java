package com.exam.Filter;

import java.util.ArrayList;

import com.exam.model.*;
import com.exam.Abstract.*;

/**
 * Classe che implementa il filtro "Essere inferiore di un certo valore" 
 * @param fields campo a cui si vuole applicare il filtro (TextPost o numPost)
 * @param lower  valore massimo di riferimento.
 * 
 * @author Camilla D'Andrea
 */

public class UpperBound extends AbstractFilter  {
	
	private int upper;
	
	

	public UpperBound(String fields, int uppers) {
	super(fields);
	setUpper(uppers);
	}
	
	
	public int getUpper() {
	return upper;
	}
	

	public void setUpper(int upper) {
	this.upper = upper;
	}

	public boolean approved(Tweet data, boolean equal) {
	boolean approvato = true;
	
	switch (getFields()) {
	
	case "textPost":
		if(equal) {
			if(data.getTextPost().length()>upper) 	
				approvato=false;
			}
		else {
			if(data.getTextPost().length()>=upper) 	
				approvato=false;
			}
		break;
	case "numPost":
		if(equal) {
			if(data.getNumPost()>upper) 	
				approvato=false;
			}
		else {
			if(data.getNumPost()>=upper) 	
				approvato=false;
			}
		break;
		default:approvato=false;
		break;
		}		
		if (approvato)
			return true;
		else
			return false;
}


	public ArrayList<Tweet> apply (ArrayList<Tweet> list, boolean equal) {
	ArrayList<Tweet> filtredArray = new ArrayList<Tweet>();
	for (int i = 0; i < list.size(); i++) {
		if (approved(list.get(i), equal)) {
			filtredArray.add(list.get(i));
		}
	}

	return filtredArray;
	}
	

	
}