package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public class SpecialVodkaPrototypeLiqueurCreator extends PrototypeLiqueurCreator {

	@Override
	public Liqueur createLiqueur(AbstractIngradientFactory abstractLiqueurFactory) {
		Liqueur liqueurPrototype = super.createLiqueur(abstractLiqueurFactory);
		liqueurPrototype.addIngradient(abstractLiqueurFactory.createVodka(100, 10));
		return liqueurPrototype;
	}

	@Override
	public Liqueur createLiqueur(LiqueurBuilder builder) {
		Liqueur liqueurPrototype = super.createLiqueur(builder);
		return new LiqueurBuilder(liqueurPrototype).addVodka(100, 10).get();
	}

}
