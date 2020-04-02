package background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.CocktailSearcher;
import services.DrinkIdentifier;
import util.Photo;
import util.Recipe;

public class App {

	public static void main(String[] args) throws IOException {
		//Create the UI Elements
		
		DrinkIdentifier di = new DrinkIdentifier();
		CocktailSearcher cs = new CocktailSearcher();
		List<Recipe> lRecipe = new ArrayList<Recipe>();
		
		//Start the UI
		
		Boolean stop = false;
		while (!stop) {
			//Wait for user input from the UI
			
			//Get the option selected by the user			
			//Get a picture
			Photo photo = new Photo();
			
			//Identify the drinks in the picture -> get a list of strings enumerating types of drinks
				// IF the option selected is QR code
					// call the QR code identifier
				// ELSE (the option selected is bottles)
					// call the drink identifier
					//List<String> ingredients =  di.identifyDrinks(photo);
					List<String> ingredients = new ArrayList<String>();
					ingredients.add("Vodka");
					ingredients.add("Lager");
					ingredients.add("Blue Curacao");
					ingredients.add("Cider");
			
			//Display the list of drinks in the UI
			//Get corrections from the user
			
			//Search for recipes using the ingredients listed
				//Call the coktail searcher
					lRecipe = cs.findRecipe(ingredients);		
					
			//Display relevant information in the UI
			cs.PrintAll(lRecipe);
			
			stop = true; // <--- BUG ? doesn't work 
			System.exit(0);
		}
	}
}
