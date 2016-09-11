package com.epam;

import com.epam.builder.LiqueurBuilder;
import com.epam.creator.AbstractLiqueurCreator;
import com.epam.creator.SpecialVodkaPrototypeLiqueurCreator;
import com.epam.liquer.Liqueur;

public class PrototypeSample {
	// Sample of liquor created from prototype
	public static void exec() {
		LiqueurBuilder liqueurBuilder = new LiqueurBuilder();
		AbstractLiqueurCreator liqueurCreator = new SpecialVodkaPrototypeLiqueurCreator();
		Liqueur liqueur = liqueurCreator.createLiqueur(liqueurBuilder);
		System.out.println("Luqueur created with builder from prototype");
		System.out.println(liqueur);
	}
}
