package com.exam.Service;

import java.util.*;

/**
 * Service dedicato al calcolo delle statistiche
 * richiamato nel controller
 * 
 * @author Federica Ripani
 */


import com.exam.Statistic.*;

import com.exam.model.Tweet;

public class StatsService {
	

	public Map<String, Object> calculStat(ArrayList<Tweet> database,String field, String filter){
		if (filter.isEmpty()) {

		/* stats per i campi di tipo stringa */
		if (Arrays.asList("data", "textPost", "nameUser", "languagePost", "userMentions", "hashtag").contains(field)) {
			StringStat stat = new StringStat(database, field);
			return new <Map<String, Object>>(stat.getStat());

		}

		/* stats per i campi di tipo numerico */
		if (Arrays.asList("idPost", "idUser", "numPost").contains(field)) {
			IntegerStat stat = new IntegerStat(database, field);
			return new <Map<String, Object>>(IntegerStat.getStat());
			}
		}

}
	
}
