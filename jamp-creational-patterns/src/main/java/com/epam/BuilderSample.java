package com.epam;

import com.epam.builder.LiqueurBuilder;
import com.epam.creator.AbstractLiqueurCreator;
import com.epam.creator.LiqueurCreator;
import com.epam.liquer.Liqueur;

public class BuilderSample {
	// Builder sample
	public static void exec() {
		LiqueurBuilder liqueurBuilder = new LiqueurBuilder();
		AbstractLiqueurCreator liqueurCreator = new LiqueurCreator();
		Liqueur liqueur = liqueurCreator.createLiqueur(liqueurBuilder);
		System.out.println("Luqueur created with builder");
		System.out.println(liqueur);

	}
}
