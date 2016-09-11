package com.epam.ingradient;

public class Coffee extends Ingredient {

	protected String country;

	public Coffee(Integer weight, String country) {
		super(weight);
		this.country = country;

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Coffee [country=" + country + ", weight=" + weight + "]";
	}

}
