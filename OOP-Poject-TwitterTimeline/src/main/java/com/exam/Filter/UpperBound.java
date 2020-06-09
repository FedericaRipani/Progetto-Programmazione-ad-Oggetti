package com.exam.Filter;

import java.util.ArrayList;

import com.exam.model.*;
import com.exam.Abstract.*;

/**
 * Classe che implementa il filtro "Essere superiore di un certo valore" 
 * @param fields campo a cui si vuole applicare il filtro (TextPost o numPost)
 * @param lower  valore minimo di riferimento.
 * 
 * @author Camilla D'Andrea
 */

public class UpperBound extends AbstractFilter  {
	

	private int lower;
	
	public UpperBound(String fields, int lowers) {
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