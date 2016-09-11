package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public abstract class AbstractLiqueurCreator {

	public abstract Liqueur createLiqueur(AbstractIngradientFactory abstractLiqueurFactory);
	
	public abstract Liqueur createLiqueur(LiqueurBuilder builder);
}
