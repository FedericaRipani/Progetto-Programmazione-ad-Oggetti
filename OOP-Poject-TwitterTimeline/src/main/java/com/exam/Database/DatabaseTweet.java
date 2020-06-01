package com.exam.Database;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.exam.model.*;
import com.exam.Service.*;

/**
 * Definisce un array list di Tweet
 * @return ArrayList di oggetti di tipo Tweet
 * 
 * @author Federica Ripani
 */

public class DatabaseTweet{
	
	private ArrayList<Tweet> tweets;
	private JSONArray JsonArray;
	
	public DatabaseTweet() throws IOException{
		
		 JsonArray = new Downloader().DownloaderJson();
		 tweets = new ArrayList<Tweet>(); 
		 
		 for (int i=0; i<JsonArray.length(); i++) {
			 
			 JSONObject json = JsonArray.getJSONObject(i);
			 JSONObject jsonEnt = JsonArray.getJSONObject(i).getJSONObject("entities");
			 JSONObject jsonUs = JsonArray.getJSONObject(i).getJSONObject("user");
			 
			 JSONArray jsonUsMent = new JSONArray (jsonEnt.get("user_mentions").toString());
			 JSONArray jsonHashtags = new JSONArray (jsonEnt.get("hashtags").toString());
			 JSONObject language = JsonArray.getJSONObject(i).getJSONObject("metadata");
			 
			 String[] mentions = new String[jsonUsMent.length()];
			 
			 for(int j = 0; j < mentions.length; j++) {
				 mentions[j] = jsonUsMent.getJSONObject(j).getString("screen_name");
			 }
			 
			 String[] hashtags = new String[jsonHashtags.length()];
			 
			 for(int k = 0; k < hashtags.length; k++) {
				 hashtags[k] = jsonHashtags.getJSONObject(k).getString("text");
			 }
			 
			
			 tweets.add(new Tweet(json.getString("created_at"),            //data
					 			  json.getInt("id_str"),                   //id post
					 			  json.getString("text"),                  //testo
					 			  jsonUs.getInt("id_str"),                 //id user  
					 			  jsonUs.getString("screen_name"),         //nome user
					 			  jsonUs.getInt("listed_count"),           //numero di post dello user
					 			  language.getString("iso_language_code"), //lingua post
					 			  mentions,                                //menzioni
					 			  hashtags));                              //hashtag
			 
			}
	}
	
	public ArrayList<Tweet> getAll() {
		return tweets;
	}
	
}