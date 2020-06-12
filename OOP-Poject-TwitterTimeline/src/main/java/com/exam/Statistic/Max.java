package com.exam.Statistic;

import java.util.ArrayList;
import com.exam.Abstract.*;
import com.exam.model.Tweet;
import com.exam.Service.*;

/**
	 * Calcola il massimo di una collezione di interi
	 * 
	 * @param vett = ArrayList da esaminare
	 * @param field = campo dell'ArrayList sul quale effettuare le statistiche
	 * @return massimo = valore della statistiche calcolato come int
	 * 
	 * @author Camilla D'Andrea
*/

public class Max  extends AbstractStatistic {

	@Override
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);

		if (temp.size() == 0)
			return 0;
		else {
			int maximum = temp.get(0);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) > maximum)
					maximum = temp.get(i);
			}
			return maximum;
		}
	}
}
