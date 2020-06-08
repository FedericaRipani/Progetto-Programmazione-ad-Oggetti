package com.exam.Filter;

import java.util.ArrayList;
/**
 * Classe che imp0lementa il filtro "Essere minore di un certo valore"
 * 
 * @param fields = Campo a cui si vuole applicare il filtro (TextPost o numPost)
 * @param uppers = Valore di riferimento.
 * 
 * @author Federica Ripani
 */

import com.exam.Interface.AbstractFilter;
import com.exam.model.Tweet;

public class LowerBound extends AbstractFilter {
	
	
private int upper;
	
	public LowerBound(String fields, int uppers) {
		super(fields);
		setUpper(uppers);
	}
	
	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public boolean approved(Tweet data, boolean equal)
	{
		boolean approvato = true;
		
		switch (getFields()) {
		
		case "TextPost":
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
