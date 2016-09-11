package com.epam.ingradient;

public class Cream extends Ingredient {

	private Integer fat;

	public Cream(Integer weight, Integer fat) {
		super(weight);
		this.fat = fat;
	}

	public Integer getFat() {
		return fat;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	@Override
	public String toString() {
		return "Cream [fat=" + fat + ", weight=" + weight + "]";
	}

}
