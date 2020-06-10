package com.exam.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

import com.exam.Service.StatsService;
import com.exam.model.Tweet;



public class Occ {
	
	public Map<String, Object> occurrence(ArrayList<Tweet> vett, String field) throws JSONException {

		ArrayList<String> vett_c = new StatsService().convStr(vett, field);
		Map<String, Object> map = new HashMap<String, Object>();

		int occ = 0;
		String str = null;
		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(vett_c);

		for (int i = 0; i < vett.size(); i++) {

			occ = 0;

			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).equals(vett_c.get(i)) && !vett_c.get(i).isEmpty()) {
					occ++;
					str = temp.get(j);
					temp.remove(j);
					j--;
					map.put(str, occ);
				}
			}
		}
		return map;
	}

}
