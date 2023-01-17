package com.epam.Json_operation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOperation2 {

	public static void searchElementsByArrayBased() throws StreamReadException, DatabindException, IOException {
		FileReader fileReader = new FileReader(".//JsonFile//jsonF.json");
		ObjectMapper mapper = new ObjectMapper();
		
		List<?> list = mapper.readValue(fileReader, ArrayList.class);
		list.forEach(e->{
			Map<?, ?> j =(LinkedHashMap<?, ?>) e;
			System.out.println(((HashMap) ((HashMap) j.get("address")).get("geo")).get("lat"));
		});
				
	}
	
	public static void searchElementsByObjectBased() throws StreamReadException, DatabindException, IOException {
		FileReader fileReader = new FileReader(".//JsonFile//jsonF.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<?, ?> map = mapper.readValue(fileReader, LinkedHashMap.class);
		System.out.println(((Map<?, ?>) map.get(5)).get("id"));
		
	}
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		searchElementsByArrayBased();
		
	}
}
