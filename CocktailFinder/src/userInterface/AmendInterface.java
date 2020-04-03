package userInterface;

import java.util.List;
import java.util.Scanner;

/** Interface used to amend the list of ingredients returned by the drink identifier
 *
 */
public class AmendInterface {
	
	/** Receives the input of the user and modifies the list of ingredients accordingly
	 * 
	 * @param ingredients a list of strings enumerating cocktail ingredients
	 * @return the same List object, modified by the user
	 */
	public List<String> amend(List<String> ingredients) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		
		System.out.println("Ingredients selected :");
		System.out.println(ingredients);
		System.out.println("Do you wish to change something ? (y/n)");
		input = scanner.nextLine();
		//If Y or y is entered
		if (input.startsWith("y") || input.startsWith("Y")) {
			boolean stop = false;
			while (!stop) {
				System.out.println("What do you want to change ?");
				System.out.println("Remove (r), Add (a), Finish (f)");
				input = scanner.nextLine();
				if (input.startsWith("r") || input.startsWith("R")) {
					System.out.print("Remove ");
					String toRemove = scanner.nextLine();
					ingredients.remove(toRemove);
				}
				if (input.startsWith("a") || input.startsWith("A")) {
					System.out.print("Add ");
					String toAdd = scanner.nextLine();
					ingredients.add(toAdd);
				}
				if (input.startsWith("f") || input.startsWith("F")) {
					stop = true;
					System.out.println("ok");
				}
				System.out.println("Ingredients selected :");
				System.out.println(ingredients);
			}
		// Anything else is selected
		} else {
			System.out.println("ok");
		}
		
		return ingredients;
	}
	
}
