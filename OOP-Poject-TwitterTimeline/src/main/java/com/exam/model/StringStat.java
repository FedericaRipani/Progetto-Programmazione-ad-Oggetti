package com.exam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.Statistic.*;
import com.exam.model.Tweet;

/**
 * Classe che eredita da Stats e crea la mappa(campo-valore)
 * formata dalle statistiche contando le occorrenze 
 * sui campi di tipo String
 * 
 * @author Camilla D'Andrea
 *
 */
public class StringStat {
	
	private Stats T;
	

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException
	{
		
		super();
		Map<String, Object> map = new HashMap<String, Object>();
		map = new Occ().occurrence(vett, field);
		
		T = new Stats(map);
	}

	public Stats getStat() {
		return T;
	}


}
