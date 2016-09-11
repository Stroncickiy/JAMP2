package com.epam.ingradient;

public class Eggs extends Ingredient {

	public Eggs(Integer weight) {
		super(weight);
	}

	@Override
	public String toString() {
		return "Eggs [weight=" + weight + "]";
	}

}
