package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Abstract.*;
import com.exam.Service.StatsService;
import com.exam.model.Tweet;


/**
 * Calcola la somma di una collezione di interi
 * 
 * @param vett = ArrayList da esaminare
 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
 * @return sum = valore della statistiche calcolato come int
 * 
 * @author Camilla D'Andrea
 */

public class Sum extends AbstractStatistic {

	
	public double calcola(ArrayList<Tweet> vett, String field) {
		int somma = 0;
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);
		for (int i = 0; i < temp.size(); i++)
			somma = somma + temp.get(i);
		return somma;
	}

}
