package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public class PrototypeLiqueurCreator implements AbstractLiqueurFromFactoryCreator {

	protected Liqueur liqueurPrototype;
 
	public PrototypeLiqueurCreator() {
		this.liqueurPrototype = new LiqueurBuilder()
				.addCoffee(10, "Africa")
				.addWater(100)
				.addVodka(100, 10)
				.addEggs(10)
				.get();
	}

	@Override
	public Liqueur createLiqueur(AbstractIngradientFactory abstractLiqueurFactory) {
		try {
			return (Liqueur) liqueurPrototype.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return liqueurPrototype;
	}

}
