package com.epam.ingradient;

public class Water extends Ingredient {

	public Water(Integer weight) {
		super(weight);
	}

	@Override
	public String toString() {
		return "Water [weight=" + weight + "]";
	}

}
