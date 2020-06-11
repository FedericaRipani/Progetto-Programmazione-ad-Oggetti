package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exam.Statistic.*;
import com.exam.model.*;

/**
 * Classe di Test che verifica il corretto funzionamento, quindi risultato
 * dei metodi definiti per le statistiche, prendendo in analisi
 * un campione di 4Tweet creati ed inseriti in un apposito ArrayList
 * 
 * @author Camilla D'Andrea
 *
 */


class TestMetodsStats {
	
	Tweet t1;Tweet t2;Tweet t3;Tweet t4;
	ArrayList<Tweet> array= new ArrayList<Tweet>();;
	double max;double min;double avg;double std;double sum;
	Map<String, Object> map = new HashMap<String, Object>();

	@BeforeEach
	void setUp() throws Exception {
	Tweet t1 = new Tweet("11Sett",1 ,"Amo le camminate in montagna" , 1087888, "Camilla", 110, "it", null,null) ;
	Tweet t2 = new Tweet("23Mag", 2,"Giulianova è top" , 1087930, "Federica", 230, "it", null,null) ;
	Tweet t3 = new Tweet("20Nov",3 , "Il terremoto mi ha segnato", 258024, "Fabio", 599, "it", null, null);
	Tweet t4 = new Tweet("11Nov", 4, "Quest anno non si va al mare :(", 1067456, "Camilla", 3, "it", null, null);
	array.add(t1);array.add(t2);array.add(t3);array.add(t4);
	
	max = new Max().calcola(array, "numPost");
	sum= new Sum().calcola(array,"idPost");
	min = new Min().calcola(array, "numPost");
	avg = new Avg().calcola(array,"idPost");
	std = new Std().calcola(array, "numPost");
	map = new Occ().occurrence(array, "nameUser");
	
	
	
	
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals(599,max);
		assertEquals(10,sum);
		assertEquals(3,min);
		assertEquals(2.5,avg);
		assertEquals(224.70480635714048,std);
		assertEquals(2, map.get("Camilla"));
		
	}

}
