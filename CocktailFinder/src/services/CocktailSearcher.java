package services;

import java.io.IOException;
import java.util.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import util.Recipe;

import java.util.concurrent.TimeUnit; //usefull for debug

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class CocktailSearcher {	
	
	/** Finds recipes in theCocktailDB that use given ingredients
	 * 
	 * @param ingredients a list of strings enumerating cocktail ingredients
	 * @return a List of Recipe objects
	 * @throws IOException 
	 */
	public List<Recipe> findRecipe(List<String> ingredients) {
  
		List<Recipe> lRecipe = new ArrayList<Recipe>();
	    ListIterator<String> i = ingredients.listIterator();
	    String reader = null;
		String ingredient = null;
		JSONParser jsonParser = new JSONParser();
		Object nameCocktail = null;
		Map<String, Integer> counterCocktail = new HashMap<>();
		OkHttpClient client = new OkHttpClient();
		
	      while(i.hasNext()){
	    	  ingredient = i.next();
	    	  System.out.println(ingredient);
	    	  
	    	  try {
	    		  
	    		  Request request = new Request.Builder()
				    	.url("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingredient)	    	
				    	.get()
				        .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
				        .addHeader("x-rapidapi-key", "4527d57cc6msh768e09bb02bba03p172fd8jsn48546d794e1f")
				        .build();
	    	 
	      		  reader = client.newCall(request).execute().body().string();
	      		  //System.out.println(reader);
	      		  
	      		
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	            JSONArray lang = (JSONArray) jsonObject.get("drinks");
	            Iterator i2 = lang.iterator();
	            while (i2.hasNext()) {
	                JSONObject innerObj = (JSONObject) i2.next();
	                nameCocktail =innerObj.get("strDrink");
	                if(counterCocktail.containsKey(nameCocktail)) {
	                	counterCocktail.computeIfPresent(nameCocktail.toString(), (k,v) -> v+1);
	                } else {
	                	counterCocktail.put(nameCocktail.toString(), 1);	                	
	                }
	                
	                //System.out.println("The name of the cocktail is " + nameCocktail);
	            }
	      		
	          //System.out.println("wait 2s");
	          //TimeUnit.SECONDS.sleep(2);
	    	  } catch (Exception e) {
	    		  e.printStackTrace();
	    	  }
	    	  
	      }
	      //System.out.println(counterCocktail.size() + " cocktails found !");
	      System.out.println();
	      Iterator i3 = counterCocktail.entrySet().iterator();
	      while(i3.hasNext()) {
	    	  Map.Entry mapEntry = (Map.Entry) i3.next();
	    	  //Clear every cocktail with just one ingredient.
	    	  if(!mapEntry.getValue().equals(1)) {
	    		  System.out.println("Key: " + mapEntry.getKey() + " | Val: " +mapEntry.getValue());
	    		  //System.out.println("wait 2s");
			      //TimeUnit.SECONDS.sleep(2);
	    		  //Call CocktailDB for every cocktail potential
	    		  try {
		    		  
		    		  Request request = new Request.Builder()
					    	.url("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + mapEntry.getKey())	    	
					    	.get()
					        .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
					        .addHeader("x-rapidapi-key", "4527d57cc6msh768e09bb02bba03p172fd8jsn48546d794e1f")
					        .build();
		    	 
		      		  reader = client.newCall(request).execute().body().string();
		      		  JSONObject jsonRecipe = (JSONObject) jsonParser.parse(reader);
		            
		      		  //Put it in a recipe and add it to lRecipe.
		    		  Recipe recipe = new Recipe(jsonRecipe);
		    		  lRecipe.add(recipe);
		    		  
		    		  
	    		  } catch (Exception e) {
	    			  e.printStackTrace();
	    		  }
	    	  }
	      }
	      
	      
		
		return lRecipe;
		}
	
}
