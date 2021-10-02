package com.crm.autodesk.GenericUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	/*
	 * this methods read the data from json file @throws throwable
	 * 
	 */
	 public String readDataFromJSON(String key) throws Throwable
	 {
		 // read the data from json file 
		 FileReader file = new FileReader("./commonData.json");
		
		  //convert the json file into java 
		 JSONParser jsonobj = new JSONParser();
		 Object jobj = jsonobj.parse(file);
		 
		 //type cast to java obj to hashmap
		 
		 HashMap map = (HashMap)jobj;
		 String value = map.get(key).toString();
		
		// return the value
		 return value;
		
	}
}