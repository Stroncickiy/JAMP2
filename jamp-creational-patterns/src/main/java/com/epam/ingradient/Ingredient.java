package com.epam.ingradient;

public abstract class Ingredient {
	protected Integer weight;

	public Ingredient(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
