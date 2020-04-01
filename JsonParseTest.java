package CoctelApp;
 //package com.javacodegeeks.javabasics.jsonparsertest;
  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
  
public class JsonParseTest {
	
	static OkHttpClient client = new OkHttpClient();
    static Request request = new Request.Builder()
        //.url("https://the-cocktail-db.p.rapidapi.com/lookup.php?i=11227")
    	//.url("https://www.thecocktaildb.com/api/json/v1/1/random.php")

    	//.url("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=GreenGoblin")
    	.get()
        .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
        .addHeader("x-rapidapi-key", "4527d57cc6msh768e09bb02bba03p172fd8jsn48546d794e1f")
        .build();
 
    public static void main(String[] args) {
    	String reader = null;
    	try {
    		reader = client.newCall(request).execute().body().string();
    		System.out.println(reader);
        	//System.out.println("we are in"); //DEBUG
 
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
 
            // get an array from the JSON object
            JSONArray lang = (JSONArray) jsonObject.get("drinks");

            Iterator i = lang.iterator();
 
            // take value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("The name of the cocktail is " + innerObj.get("strDrink"));
                System.out.println("Here, the list of Ingredients : " + "\n");
               
                int j = 1;
                while(innerObj.get("strIngredient" + j) != null && j<=15) {
                	System.out.println("Ingredient : " + innerObj.get("strIngredient" + j));
  
                	System.out.println("Measure : " + innerObj.get("strMeasure" + j));
                	j++;
                }
                System.out.println("\n");
                System.out.println("Instructions : " + "\n" + innerObj.get("strInstructions") + "\n");
                
                System.out.println("photo : " + "\n" + innerObj.get("strDrinkThumb"));
                /*System.out.println("The name is " + innerObj.get("strDrink") +
                		
                        " with instructions : " + "\n" + innerObj.get("strInstructions"));*/
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  
}