package com.epam.factorymethod;

import com.epam.ingradient.Coffee;
import com.epam.ingradient.Ingredient;

public class CoffeeCreator implements IngredientCreatorPerfomer {

	@Override
	public Ingredient createIngradient() {
		return new Coffee(100, "Africa");
	}

}
