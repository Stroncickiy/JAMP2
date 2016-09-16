package com.epam;

import com.epam.creator.AbstractLiqueurFromFactoryCreator;
import com.epam.creator.SpecialVodkaPrototypeLiqueurCreator;
import com.epam.factory.SimpleIngradientFactory;
import com.epam.liquer.Liqueur;

public class PrototypeSample {
	// Sample of liquor created from prototype
	public static void exec() {
		AbstractLiqueurFromFactoryCreator liqueurCreator = new SpecialVodkaPrototypeLiqueurCreator();
		Liqueur liqueur = liqueurCreator.createLiqueur(SimpleIngradientFactory.getInstance());
		System.out.println("Luqueur created with factory from prototype");
		System.out.println(liqueur);
	}
}
