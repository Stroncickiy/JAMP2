package com.epam.bridge;

public class GreenTeaMakerApi implements DrinkMakerApi {

	@Override
	public void getCup() {
		System.out.println("Cup for green tea taken ");

	}

	@Override
	public void addWater() {
		System.out.println("Water  for green tea added ");

	}

	@Override
	public void boilWater() {
		System.out.println("Water  for green tea boiled ");
	}

	@Override
	public void addDrinkConcentrate() {
		System.out.println(" green tea added ");

	}

}
