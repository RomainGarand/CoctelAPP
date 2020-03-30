package util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

/**Represents a cocktail recipe for the other classes
 *
 */
public class Recipe {
	private String name;
	private String instructions;
	private List<String> ingredients;
	private List<Amount> amounts;
	
	/** Creates a cocktail recipe from its JSON description
	 * 
	 * @param obj the JSON description of a cocktail recipe matching 
	 *            TheCoctailDB's format
	 */
	public Recipe(JsonObject obj) {
		this.name = obj.get("strDrink").toString();
		this.instructions = obj.get("strInstructions").toString();
		this.ingredients = new ArrayList<String>();
		this.amounts = new ArrayList<Amount>();
		
		int i = 1;
		while(obj.get("strIngredient" + i) != null && i<=15) {
			this.ingredients.add(obj.get("strIngredient" + i).toString());
			
			this.amounts.add(new Amount(obj.get("strMeasure" + i).toString()));
		 	i++;
		}
		
		
	}
	
	/** Retrieves the name of the cocktail
	 * 
	 *  @return the name of the cocktail as a string
	 */
	public String getName() {
		return name;
	}
	
	/** Retrieves the preparation instructions
	 * 
	 * @return a string containing instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/** Retrieves the ingredients of the cocktail
	 * 
	 * @return a List of Strings enumerating the ingredients of the cocktail
	 */
	public List<String> getIngredients() {
		return ingredients;
	}

	/** Retrieves the amounts associated with each ingredient of the cocktail
	 * 
	 * @return a List of Amount objects, ordered so that each Amount is in the
	 *         same position as the one its associated ingredient has in the
	 *         List returned by getIngredients
	 */
	public List<Amount> getAmounts() {
		return amounts;
	}
}
