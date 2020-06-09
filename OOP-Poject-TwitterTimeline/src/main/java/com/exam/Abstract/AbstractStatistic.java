package com.exam.Abstract;

import java.util.ArrayList;
import java.util.Map;

import com.exam.model.Tweet;

public abstract class AbstractStatistic {
	   private Map<String, Object> map;


		public AbstractStatistic() {

		}

	    public abstract void Stats(Map<String, Object> map);


		public abstract int calcola(ArrayList<Tweet> vett, String field);

}
