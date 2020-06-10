package com.exam.Statistic;

import java.util.ArrayList;

import com.exam.Abstract.*;
import com.exam.Service.StatsService;
import com.exam.model.Tweet;



public class Std extends AbstractStatistic {
	
	@Override
	public double calcola(ArrayList<Tweet> vett, String field) {
		ArrayList<Integer> temp = new StatsService().convInt(vett, field);
		double scartiquad = 0;
		double media = new Avg().calcola(vett, field);
		for (int i = 0; i < vett.size(); i++) {
			scartiquad = scartiquad + Math.pow(Math.abs(media - temp.get(i)), 2);
		}
		double variance = scartiquad / (temp.size()); 
		return Math.sqrt(variance);
	}
}
