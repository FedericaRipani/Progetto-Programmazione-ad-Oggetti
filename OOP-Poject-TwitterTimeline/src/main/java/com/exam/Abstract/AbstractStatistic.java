package com.exam.Abstract;

import java.util.ArrayList;

import com.exam.model.Tweet;

/** 
 * Classe astratta creata per includere il metodo che,
 * successivamente, verrà implementato con il suo funzionamento
 * da ogni statistica.
 * 
 * @author Federica Ripani
 *
 */

public abstract class AbstractStatistic {

		public AbstractStatistic() {

		}
		
		public abstract double calcola(ArrayList<Tweet> vett, String field);

}
