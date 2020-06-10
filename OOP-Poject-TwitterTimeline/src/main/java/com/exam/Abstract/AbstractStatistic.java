package com.exam.Abstract;

import java.util.ArrayList;


import com.exam.model.Tweet;

public abstract class AbstractStatistic {


		public AbstractStatistic() {

		}


		public abstract double calcola(ArrayList<Tweet> vett, String field);

}
