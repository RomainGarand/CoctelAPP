package services;

import java.util.ArrayList;
import java.util.List;

import util.Photo;

public class DrinkIdentifier {
	/** Mockup for the method that identifies the drinks in a picture
	 * 
	 * @param photo an object containing the information from a picture
	 * @return a List of Strings enumerating the various drinks present in the picture
	 */
	public List<String> identifyDrinks(Photo photo) {
		List<String> res = new ArrayList<String>();
		res.add("Vodka");
		res.add("Soda");
		return res;
	}
}

