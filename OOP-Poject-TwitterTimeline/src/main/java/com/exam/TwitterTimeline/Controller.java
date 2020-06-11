package com.exam.TwitterTimeline;


import java.io.IOException;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Database.*;
import com.exam.Service.FilterService;
import com.exam.Service.StatsService;
import com.exam.model.Metadati;
import com.exam.model.Tweet;

/**
 * 
 * Il controller rappresenta e contiene tutte le richieste che si possono
 * fare al server
 * 
 * @author Camilla D'Andrea
 * @author Federica Ripani
 */

@RestController
public class Controller {
	
	private DatabaseMetadati meta;
	private ArrayList<Tweet> database;
	private ArrayList<Tweet> vett;
	private Boolean val;
	private FilterService filterService;
	private Map<String, Object> map;
	private StatsService statService;


	public Controller() throws IOException {
		
		map=new HashMap<String, Object>();
		filterService = new FilterService();
		statService= new StatsService();
		vett= new ArrayList<Tweet>();
		meta = new DatabaseMetadati();
		database = new DatabaseTweet().getAll();
		
		
		System.out.println("\n\n ---------------------- ");
		System.out.println("|**********************|");
		System.out.println("|*  APPLICATION READY *|");
		System.out.println("|**********************|");
		System.out.println(" ----------------------\n\n");
	}
	
	/**
	 * Gestisce la chiamata che fa visualizzare i metadati
	 * con un codice HTTP 200
	 * @return la collezione di metadati
	 */
	
	@GetMapping("/getMeta")
	public ResponseEntity<ArrayList<Metadati>> meta() {
		return new ResponseEntity<ArrayList<Metadati>>(meta.getAll(), HttpStatus.OK);
	
	}
	
	/**
	 * Gestisce la chiamata che fa visualizzare i tweet
	 * con un codice HTTP 200
	 * @return la collezione di tweet
	 */
	
	@GetMapping("/getTweets")
	public ResponseEntity<ArrayList<Tweet>> Twit() {
		return new ResponseEntity<ArrayList<Tweet>>(database, HttpStatus.OK);
	
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/filtering")
	public ResponseEntity filters(@RequestParam String filter) throws JSONException {
		JSONObject filtro = new JSONObject(filter);
		vett = filterService.filters(database, filtro);
		val= filterService.getFlag();
		
		if(val==false)
			return new ResponseEntity<String>("Nessun filtro selezionata/esistente", HttpStatus.BAD_REQUEST);
		
		if (vett.size() == 0)
			return new ResponseEntity<String>("La ricerca non ha prodotto risultati", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<ArrayList<Tweet>>(vett, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/stats")
	public ResponseEntity statistiche(@RequestParam(required = true) String field,
			@RequestParam(required = false, defaultValue = "") String filter) throws JSONException {
		map=statService.calculStat(database, field, filter);
		val=statService.getFlag();
		if(val==false)
			return new ResponseEntity<String>("Nessun filtro selezionato/esistente", HttpStatus.NOT_IMPLEMENTED);
		else
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}

}
