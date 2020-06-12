package com.exam.Statistic;

import java.util.ArrayList;
import com.exam.Abstract.AbstractStatistic;
import com.exam.model.Tweet;

/**
 * Calcola la media di una collezione di interi
 * 
 * @param vett = ArrayList di tweet
 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
 * @return media in formato double
 * 
 * @author Federica Ripani
 */

public class Avg extends AbstractStatistic {
	public Avg() {
		
	}
	
	
	public double calcola(ArrayList<Tweet> vett, String field) {
		
		return	new Sum().calcola(vett, field) / vett.size();
		
	}

}
