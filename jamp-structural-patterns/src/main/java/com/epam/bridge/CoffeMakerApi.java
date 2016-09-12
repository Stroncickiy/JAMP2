package com.epam.bridge;

public class CoffeMakerApi implements DrinkMakerApi {

	@Override
	public void getCup() {
		System.out.println("Cup for coffee  taken ");

	}

	@Override
	public void addWater() {
		System.out.println("Water  for coffee added ");
	}

	@Override
	public void boilWater() {
		System.out.println("Water  for coffee boiled ");

	}

	@Override
	public void addDrinkConcentrate() {
		System.out.println("coffee added ");

	}

}
