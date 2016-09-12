package com.epam.bridge;

public abstract class DrinkMaker {
	protected DrinkMakerApi drinkMakerApi;

	protected DrinkMaker(DrinkMakerApi teaMakerApi) {
		this.drinkMakerApi = teaMakerApi;
	}

	public abstract void makeDrink();

}
