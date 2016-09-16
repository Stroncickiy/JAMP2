package com.epam;

import com.epam.factorymethod.CoffeeCreator;
import com.epam.factorymethod.IngradientCreator;
import com.epam.factorymethod.VodkaCreator;
import com.epam.ingradient.Ingredient;

public class FactoryMethodSample {

	public static void exec() {
		IngradientCreator ingradientCreator = new IngradientCreator();
		
		Ingredient vodka = ingradientCreator.createIngradient(new VodkaCreator());
		System.out.println("ingredient created " + vodka.getClass());

		Ingredient coffee = ingradientCreator.createIngradient(new CoffeeCreator());
		System.out.println("ingredient created " + coffee.getClass());

	}
}
