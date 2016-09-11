package com.epam.ingradient;

public class Vodka extends Ingredient {
	protected Integer alcohol;
	public Vodka(Integer weight, Integer alcohol) {
		super(weight);
		this.alcohol = alcohol;
	}


	public Integer getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	@Override
	public String toString() {
		return "Vodka [alcohol=" + alcohol + ", weight=" + weight + "]";
	}

}
