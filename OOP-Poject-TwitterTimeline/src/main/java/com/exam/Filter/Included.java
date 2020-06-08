package com.exam.Filter;
import com.exam.Interface.*;
import com.exam.model.Tweet;

import java.util.ArrayList;

/**
 * Classe che implementa il filtro "Essere incluso in un certo intervallo" 
 * @param fields campo a cui si vuole applicare il filtro (TextPost o numPost)
 * @param lower  valore minimo di riferimento per l'intervallo.
 * @param upper valore massimo di riferimento per l'intervallo.
 * 
 * @author Camilla D'Andrea
 */


public class Included extends AbstractFilter {
		
		private int upper;
		private int lower;
		
		
		
		public Included(String fields,int upper, int lower) {
			super(fields);
			setUpper(upper);
			setLower(lower);
		}
		public int getUpper() {
			return upper;
		}
		public void setUpper(int upper) {
			this.upper = upper;
		}
		public int getLower() {
			return lower;
		}
		public void setLower(int lower) {
			this.lower = lower;
		}
		
		@Override
		public boolean approved(Tweet data, boolean equal) {
			boolean approvato = true;

			switch (getFields()) {
			case "TextPost":
				if(equal) {
					if(data.getTextPost().length()<lower || data.getTextPost().length()>upper) 	
						approvato=false;
					}
				else {
					if(data.getTextPost().length()<=lower || data.getTextPost().length()>upper) 	
						approvato=false;
					}
				break;
			case "numPost":
				if(equal) {
					if(data.getNumPost()<lower || data.getNumPost()>upper) 	
						approvato=false;
					}
				else {
					if(data.getNumPost()<=lower || data.getNumPost()>=upper) 	
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