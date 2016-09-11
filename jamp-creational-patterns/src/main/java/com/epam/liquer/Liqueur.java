package com.epam.liquer;

import java.util.ArrayList;
import java.util.List;

import com.epam.ingradient.Ingredient;

public class Liqueur implements Cloneable {
	private List<Ingredient> ingradients;

	public Liqueur() {
		this.ingradients = new ArrayList<>();
	}

	public Liqueur(List<Ingredient> ingradients) {
		this.ingradients = ingradients;
	}

	public List<Ingredient> getIngradients() {
		return ingradients;
	}

	public void setIngradients(List<Ingredient> ingradients) {
		this.ingradients = ingradients;
	}

	public void addIngradient(Ingredient ingradient) {
		ingradients.add(ingradient);
	}

	@Override
	public String toString() {
		return "Liqueur [ingradients=" + ingradients + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Liqueur(ingradients);
	}
}
