package com.exam.Database;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.exam.model.*;
import com.exam.Service.*;

/**
 * Classe che definisce un array list di Tweet
 * 
 * @return ArrayList di oggetti di tipo Tweet
 * 
 * @author Federica Ripani
 */

public class DatabaseTweet{
	
	private static ArrayList<Tweet> tweets;
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
			 String Hashtag = TextHashtag(jsonHashtags);
			 String Mention = Mentions(jsonUsMent);
			 
			
			 tweets.add(new Tweet(json.getString("created_at"),            //data
					 			  json.getInt("id_str"),                   //id post
					 			  json.getString("text"),                  //testo
					 			  jsonUs.getInt("id_str"),                 //id user  
					 			  jsonUs.getString("screen_name"),         //nome user
					 			  jsonUs.getInt("listed_count"),           //numero di post dello user
					 			  language.getString("iso_language_code"), //lingua post
					 			  Mention,                                    //menzioni
					 			  Hashtag));    //hashtag
			 
			}
	}
	
	
	public static ArrayList<Tweet> getAll() {
		return tweets;
	}
	
	
	public String TextHashtag(JSONArray arrayH) {
		String HashtagText = null;
		int lengthH = arrayH.length();
		for(int k=0; k<lengthH; k++) 
			HashtagText = arrayH.getJSONObject(k).get("text").toString();
		
		return HashtagText;		
	}
	
	
	public String Mentions(JSONArray arrayM) {
		String name=null;
		int lengthM = arrayM.length();
		for(int j=0; j<lengthM; j++) 
			name = arrayM.getJSONObject(j).get("screen_name").toString();
		
		return name;		
	}
	
	
	
}