package CoctelApp;

public enum Choix {
	WithID ("https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007"),
	WithName ("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita"),
	WithFirstLetter ("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a"),
	WithRandom ("https://www.thecocktaildb.com/api/json/v1/1/random.php"),
	WithIngredient ("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=Gin");

	private String url = "";

	//Constructeur
	Choix(String url) {
		this.url = url;
	}

	public String toString() {
		return url;
	}
	public String toStringEnum() {
		return name();
	}
}