package com.epam.bridge;

public class SimpleDrinkMaker extends DrinkMaker {

	public SimpleDrinkMaker(DrinkMakerApi drinkMakerApi) {
		super(drinkMakerApi);
	}

	@Override
	public void makeDrink() {
		drinkMakerApi.getCup();
		drinkMakerApi.addWater();
		drinkMakerApi.boilWater();
		drinkMakerApi.addDrinkConcentrate();

	}

}
