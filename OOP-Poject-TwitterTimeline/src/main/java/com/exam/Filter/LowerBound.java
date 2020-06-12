package com.exam.Filter;

import java.util.ArrayList;

/**
 * Classe che implementa il filtro "Essere maggiore di un certo valore"
 * 
 * @param fields = Campo a cui si vuole applicare il filtro (TextPost o numPost)
 * @param lowers = Valore di riferimento.
 * 
 * @author Federica Ripani
 */

import com.exam.Abstract.AbstractFilter;
import com.exam.model.Tweet;

public class LowerBound extends AbstractFilter {
	
	
private int lower;
	
	public LowerBound(String fields, int lowers) {
		super(fields);
		setLower(lowers);
	}
	
	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	@Override
	public boolean approved(Tweet data, boolean equal)
	{
		boolean approvato = true;
		
		switch (getFields()) {
		
		case "TextPost":
			if(equal) {
				if(data.getTextPost().length()<lower) 	
					approvato=false;
				}
			else {
				if(data.getTextPost().length()<=lower) 	
					approvato=false;
				}
			break;
		case "numPost":
			if(equal) {
				if(data.getNumPost()<lower) 	
					approvato=false;
				}
			else {
				if(data.getNumPost()<=lower) 	
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

	
	
	
	@Override
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
