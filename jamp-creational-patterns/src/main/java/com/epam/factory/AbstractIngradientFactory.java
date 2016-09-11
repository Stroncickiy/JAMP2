package com.epam.factory;

import com.epam.ingradient.Coffee;
import com.epam.ingradient.Cream;
import com.epam.ingradient.Eggs;
import com.epam.ingradient.Limon;
import com.epam.ingradient.Vodka;
import com.epam.ingradient.Water;

public abstract class AbstractIngradientFactory {
	public abstract Eggs createEggs(Integer weigth);

	public abstract Vodka createVodka(Integer weight, Integer alcohol);

	public abstract Limon createLimon(Integer weight);

	public abstract Water createWater(Integer weight);

	public abstract Coffee createCoffee(Integer weight, String country);

	public abstract Cream createCream(Integer weight, Integer fat);
	
}
