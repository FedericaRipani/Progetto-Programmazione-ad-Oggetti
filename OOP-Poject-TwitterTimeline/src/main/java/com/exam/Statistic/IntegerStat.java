package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.exam.model.Tweet;

public class IntegerStat {
	
	private Stats T;
	
	public IntegerStat(ArrayList<Tweet> vett, String field) throws JSONException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Field", field);
		
	}

}
