package com.epam.builder;

import com.epam.ingradient.Coffee;
import com.epam.ingradient.Cream;
import com.epam.ingradient.Eggs;
import com.epam.ingradient.Vodka;
import com.epam.ingradient.Water;
import com.epam.liquer.Liqueur;

public class LiqueurBuilder {
	private Liqueur liqueur;

	public LiqueurBuilder() {
		liqueur = new Liqueur();
	}

	public LiqueurBuilder(Liqueur liqueur) {
		this.liqueur = liqueur;
	}

	public LiqueurBuilder addEggs(Integer weight) {
		liqueur.addIngradient(new Eggs(weight));
		return this;
	}

	public LiqueurBuilder addVodka(Integer weight, Integer alcohol) {
		liqueur.addIngradient(new Vodka(weight, alcohol));
		return this;
	}

	public LiqueurBuilder addCoffee(Integer weight, String country) {
		liqueur.addIngradient(new Coffee(weight, country));
		return this;
	}

	public LiqueurBuilder addCream(Integer weight, Integer fat) {
		liqueur.addIngradient(new Cream(weight, fat));
		return this;
	}

	public LiqueurBuilder addWater(Integer weight) {
		liqueur.addIngradient(new Water(weight));
		return this;
	}

	public Liqueur get() {
		return liqueur;
	}

}
