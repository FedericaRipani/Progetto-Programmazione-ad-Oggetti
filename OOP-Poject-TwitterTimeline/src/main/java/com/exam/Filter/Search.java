package com.exam.Filter;

import java.util.ArrayList;

/**
 * Classe che implementa il filtro "Cerca i tweets con una determinata parola nel testo, nome Utente o hashtag"
 * 
 * @param fields = campo a cui si vuole applicare il filtro (TextPost, NameUser o Hashtag)
 * @param value = parola da cercare.
 * 
 * @author Federica Ripani
 */

import com.exam.Interface.AbstractFilter;
import com.exam.model.Tweet;

public class Search extends AbstractFilter{
	private String value;

	public Search(String fields, String value) {
		super(fields);
		setValue(value);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public boolean approved(Tweet data, boolean equal) {
		boolean approvato = true;
		boolean found = true;
		

		switch (getFields()) {
		case "TextPost":
			if (equal) {
				
				found = data.getTextPost().contains(value);
				if (found == false)
					approvato = false;
			} 
			break;

		case "NameUser":
			if (equal) {
				found = data.getNameUser().contains(value);
				if (found == false)
					approvato = false;
			}
			break;
		case "Hashtag":
			if (equal) {
				for(int i=0; i<data.getHashtag().length; i++) {
					if (data.getHashtag()[i] == value)
						found=true;
				}
				
				if (found == false)
					approvato = false;
			} 
			break;
		default:
			break;
		}

		if (approvato)
			return true;
		else
			return false;
	}

	/**
	 * @param list  lista di elementi che possono essere eventualmente inseriti
	 *              nella lista filtrata.
	 * @param equal flag da passare alla funzione approved. Se il flag approvato
	 *              dell'elemento processato è true l'elemento viene inserito nella
	 *              lista filtrata, altrimenti viene processato l'elemento
	 *              successivo.
	 */
	@Override
	public ArrayList<Tweet> apply( ArrayList<Tweet> list, boolean equal) {
	     ArrayList<Tweet> FoundArray = new  ArrayList<Tweet>();
		for (int i = 0; i < list.size(); i++) {
			if (approved(list.get(i), equal))
				FoundArray.add(list.get(i));
		}

		return FoundArray;
	}



}
