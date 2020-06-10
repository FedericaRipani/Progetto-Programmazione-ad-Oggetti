package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.model.Tweet;

public class IntegerStat  extends Stats{
	
	private Stats T;
	private double min;
	
	public IntegerStat(ArrayList<Tweet> vett, String field) throws JSONException {
		super();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Field", field);
		map.put("Minimo", min = new Min().calcola(vett, field));
		map.put("Media", avg = new Avg().calcola(vett, field));
		
		//                                      //
		// Qui metteremo le  altre statistiche //
		//                                    //
		
		T = new Stats(map);
		
		
	}
	public Stats getStat() {
		return T;
	}


}
