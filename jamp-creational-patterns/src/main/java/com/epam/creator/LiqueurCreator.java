package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public class LiqueurCreator implements AbstractLiqueurFromFactoryCreator,AbstractLiqueurFromBuilderCreator {
	@Override
	public Liqueur createLiqueur(AbstractIngradientFactory ingradientFactory) {
		Liqueur liqueur = new Liqueur();
		liqueur.addIngradient(ingradientFactory.createCoffee(10, "Africa"));
		liqueur.addIngradient(ingradientFactory.createWater(100));
		liqueur.addIngradient(ingradientFactory.createVodka(100, 10));
		liqueur.addIngradient(ingradientFactory.createEggs(10));
		return liqueur;
	}

	@Override
	public Liqueur createLiqueur(LiqueurBuilder builder) {
		return 	builder
				.addCoffee(10, "Africa")
				.addWater(100)
				.addVodka(100, 10)
				.addEggs(10)
				.get();
	}
}
