package com.epam.factorymethod;

import com.epam.ingradient.Ingredient;
import com.epam.ingradient.Vodka;

public class VodkaCreator implements IngredientCreatorPerfomer {

	@Override
	public Ingredient createIngradient() {
		return new Vodka(100, 10);
	}

}
