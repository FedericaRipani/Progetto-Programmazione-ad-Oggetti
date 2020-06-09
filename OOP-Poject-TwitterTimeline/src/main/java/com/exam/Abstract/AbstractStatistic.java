package com.exam.Abstract;

import java.util.ArrayList;
import java.util.Map;

import com.exam.model.Tweet;

public abstract class AbstractStatistic {


		public AbstractStatistic() {

		}


		public abstract int calcola(ArrayList<Tweet> vett, String field);

}
