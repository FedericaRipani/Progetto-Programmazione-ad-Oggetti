package com.exam.Statistic;

import java.util.ArrayList;
import com.exam.Abstract.AbstractStatistic;
import com.exam.model.Tweet;


public class Avg extends AbstractStatistic {
	public Avg() {
		
	}
	
	
	public double calcola(ArrayList<Tweet> vett, String field) {
		
		return	new Sum().calcola(vett, field) / vett.size();
		
	}

}
