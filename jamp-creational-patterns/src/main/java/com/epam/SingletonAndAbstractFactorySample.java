package com.epam;

import com.epam.creator.AbstractLiqueurCreator;
import com.epam.creator.LiqueurCreator;
import com.epam.factory.SimpleIngradientFactory;
import com.epam.liquer.Liqueur;

public class SingletonAndAbstractFactorySample {

	// Example of AbstractFactory and Singleton
	public static void exec() {
		SimpleIngradientFactory ingradientFactory = SimpleIngradientFactory.getInstance();
		AbstractLiqueurCreator liqueurCreator = new LiqueurCreator();
		Liqueur liqueur = liqueurCreator.createLiqueur(ingradientFactory);
		System.out.println("Luqueur created with abstract factory");
		System.out.println(liqueur);

	}
}
