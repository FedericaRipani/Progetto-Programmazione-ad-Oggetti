package com.exam.Statistic;

import java.util.ArrayList;


import com.exam.Abstract.AbstractStatistic;
import com.exam.Service.StatsService;
import com.exam.model.*;


/**
 * Calcola il minimo di una collezione di interi
 * 
 * @param vett = ArrayList da esaminare
 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
 * @return minimo = valore della statistiche calcolato come int
 * 
 * @author Federica Ripani
 */

public class Min extends AbstractStatistic {
	
	
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);

		if (temp.size() == 0)
			return 0;
		else {
			int minimum = temp.get(0);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) < minimum)
					minimum = temp.get(i);
			}
			return minimum;
		}
	}
}
