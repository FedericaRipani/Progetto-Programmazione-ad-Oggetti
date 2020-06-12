package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exam.Service.FilterService;
import com.exam.model.Tweet;

/**
 * Classse di Test che verifica la corretta generazione di
 * una JSONException nel metodo filters del FilterService.
 * 

 * @author Federica Ripani
 *
 */




class TestExceptions {
	private JSONObject filtro1;
	private FilterService filter;
	private Tweet t1;
	private ArrayList<Tweet> array;

	@BeforeEach
	void setUp() throws JSONException, IOException {
		filter = new FilterService();
		Tweet t1 = new Tweet("11Sett",1 ,"Amo le camminate in montagna" , 1087888, "Camilla", 110, "it", null,null) ;		
		filtro1 = new JSONObject();
		filtro1.put("type", "LowerBoundE");
		filtro1.put("\\fields", "TextPost");
		filtro1.put("upper", 100);
		array = new ArrayList<Tweet>();
		array.add(t1);
	   
	}

	@AfterEach
	void tearDown() throws JSONException {
	}

	@Test
	void test() throws JSONException {
		assertThrows(JSONException.class, () -> filter.filters(array, filtro1));
	
	
	}

}
