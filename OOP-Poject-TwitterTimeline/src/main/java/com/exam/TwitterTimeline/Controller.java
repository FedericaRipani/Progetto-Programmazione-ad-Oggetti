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



	public Controller() throws IOException {
		vett= new ArrayList<Tweet>();
		meta = new DatabaseMetadati();
		database = new DatabaseTweet().getAll();
		
		System.out.println("\n\n|--------------------|");
		System.out.println("|  APPLICATION READY |");
		System.out.println("|--------------------|\n\n");
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
}
