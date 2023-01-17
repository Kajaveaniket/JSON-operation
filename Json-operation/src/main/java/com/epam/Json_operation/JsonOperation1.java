package com.epam.Json_operation;

import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonOperation1 {

	public static void checkForArray(JSONArray t, String key) {
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i) instanceof JSONObject) {
				checkForObject((JSONObject) t.get(i), key);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void checkForObject(JSONObject t, String key) {
		if (t.containsKey(key)) {
			// t.put(key, "An");
//			 t.remove(key);
			System.out.println(t.get(key));
			return;
		} else {
			t.keySet().forEach(k -> {
				if (t.get(k) instanceof JSONObject) {
					checkForObject((JSONObject) t.get(k), key);
				} else if (t.get(k) instanceof JSONArray) {
					checkForArray((JSONArray) t.get(k), key);
				}
			});
		}
	}

	public static void main(String[] args) throws IOException, ParseException, ScriptException {
		FileReader fileReader = new FileReader(".//JsonFile//jsonF.json");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(fileReader);

		String keyName = "strength";
		String newValue = "10kg";

		if (object instanceof JSONObject) {
			checkForObject((JSONObject) object, "stregth");
		} else if (object instanceof JSONArray) {

			checkForArray((JSONArray) object, "stregth");
		}

	}
}
