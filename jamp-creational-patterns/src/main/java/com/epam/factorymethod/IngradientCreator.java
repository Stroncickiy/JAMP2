package com.epam.factorymethod;

import com.epam.ingradient.Ingredient;

public class IngradientCreator {
	public Ingredient createIngradient(IngredientCreatorPerfomer ingradientCreatorImpl) {
		return ingradientCreatorImpl.createIngradient();
	}
}
