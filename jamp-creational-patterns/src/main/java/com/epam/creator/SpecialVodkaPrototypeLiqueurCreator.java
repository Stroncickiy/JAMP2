package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public class SpecialVodkaPrototypeLiqueurCreator implements AbstractLiqueurFromFactoryCreator {
	protected Liqueur liqueurPrototype;
	 
	public SpecialVodkaPrototypeLiqueurCreator() {
		this.liqueurPrototype = new LiqueurBuilder()
				.addCoffee(10, "Africa")
				.addWater(100)
				.addVodka(100, 10)
				.addEggs(10)
				.get();
	}
	public Liqueur createLiqueur(AbstractIngradientFactory abstractLiqueurFactory) {
		liqueurPrototype.addIngradient(abstractLiqueurFactory.createVodka(100, 10));
		return liqueurPrototype;
	}



}
