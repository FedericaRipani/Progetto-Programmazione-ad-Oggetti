package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.model.Tweet;


public class StringStat extends Stats {
	
	private Stats T;
	

	public StringStat(ArrayList<Tweet> vett, String field) throws JSONException
	{
		
		super();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		T = new Stats(map);
	}

	public Stats getStat() {
		return T;
	}


}
