package com.exam.Statistic;

import java.util.ArrayList;


import com.exam.Abstract.AbstractStatistic;
import com.exam.model.*;


	
public class Min extends AbstractStatistic {
	
	
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

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
