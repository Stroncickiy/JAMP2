package com.epam.factory;

import com.epam.ingradient.Coffee;
import com.epam.ingradient.Cream;
import com.epam.ingradient.Eggs;
import com.epam.ingradient.Limon;
import com.epam.ingradient.Vodka;
import com.epam.ingradient.Water;

public class SimpleIngradientFactory extends AbstractIngradientFactory {

	private static SimpleIngradientFactory instance;

	private SimpleIngradientFactory() {
	}

	@Override
	public Eggs createEggs(Integer weigth) {
		return new Eggs(weigth);
	}

	@Override
	public Vodka createVodka(Integer weight, Integer alcohol) {
		return new Vodka(weight, alcohol);
	}

	@Override
	public Limon createLimon(Integer weight) {
		return new Limon(weight);
	}

	@Override
	public Water createWater(Integer weight) {
		return new Water(weight);
	}

	@Override
	public Coffee createCoffee(Integer weight, String country) {
		return new Coffee(weight, country);
	}

	@Override
	public Cream createCream(Integer weight, Integer fat) {
		return new Cream(weight, fat);
	}

	public static SimpleIngradientFactory getInstance() {
		if (instance == null) {
			instance = new SimpleIngradientFactory();
		}
		return instance;

	}
}
