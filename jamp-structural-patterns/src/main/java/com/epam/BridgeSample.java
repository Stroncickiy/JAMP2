package com.epam;

import com.epam.bridge.CoffeMakerApi;
import com.epam.bridge.DrinkMaker;
import com.epam.bridge.DrinkMakerApi;
import com.epam.bridge.GreenTeaMakerApi;
import com.epam.bridge.SimpleDrinkMaker;

public class BridgeSample {
	public static void exec() {
		DrinkMakerApi greenTeaApi = new GreenTeaMakerApi();
		DrinkMaker teaMaker = new SimpleDrinkMaker(greenTeaApi);
		teaMaker.makeDrink();

		DrinkMakerApi coffeeMakerApi = new CoffeMakerApi();
		DrinkMaker coffeeMaker = new SimpleDrinkMaker(coffeeMakerApi);
		coffeeMaker.makeDrink();

	}
}
