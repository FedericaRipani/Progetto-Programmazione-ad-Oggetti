package com.exam.Service;

/**
 *  Service dedicato al calcolo dell'array filtrato
 *  che in base al JSONObject filtro passato dall'utente,   
 *  sceglie ed applica il filtro selezionato.
 * 
 * @author Camilla D'Andrea
 */

import com.exam.Filter.*;
import com.exam.model.Tweet;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class FilterService {

	private ArrayList<Tweet> vett;
	private Boolean flag;

	@SuppressWarnings("deprecation")
	public FilterService() {
		flag = new Boolean(false);
	}
	
	
	public ArrayList<Tweet> filters(ArrayList<Tweet> twits, JSONObject filtro) throws JSONException {
		flag=false;
		switch (filtro.getString("type")) {

		case "UpperBound": {
			UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = up.apply(twits, false);
			flag = true;
			break;
		}

		case "UpperBoundE": {
			UpperBound up = new UpperBound(filtro.getString("fields"), filtro.getInt("upper"));
			vett = up.apply(twits, true);
			flag = true;
			break;
		}

		case "LowerBound": {
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("lower"));
			vett = lo.apply(twits, false);
			flag = true;
			break;
		}

		case "LowerBoundE": {
			LowerBound lo = new LowerBound(filtro.getString("fields"), filtro.getInt("lower"));
			vett = lo.apply(twits, true);
			flag = true;
			break;
		}

		case "Included": {
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
			vett = in.apply(twits, false);
			flag = true;
			break;
		}

		case "IncludedE": {
			Included in = new Included(filtro.getString("fields"), filtro.getInt("lower"), filtro.getInt("upper"));
			vett = in.apply(twits, true);
			flag = true;
			break;
		}

		case "Search": {
			Search se = new Search(filtro.getString("fields"), filtro.getString("value"));
			vett = se.apply(twits, true);
			flag = true;
			break;
		}
		
		}
	
		return vett;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}


	public ArrayList<Tweet> getVett() {
		return vett;
	}


	public void setVett(ArrayList<Tweet> vett) {
		this.vett = vett;
	}
	
}
