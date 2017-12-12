package net.mrliuli.enumeration;

public interface Food{
	enum Appetizer implements Food{
		SALAD, SOUP, SPRING_ROLLS;
	}
	enum MainCorse implements Food{
		LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, WINDALOO;
	}
	enum Dessert implements Food{
		TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
	}
	enum Coffee implements Food{
		BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
	}
}