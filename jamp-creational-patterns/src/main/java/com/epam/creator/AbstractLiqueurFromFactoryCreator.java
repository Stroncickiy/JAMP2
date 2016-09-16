package com.epam.creator;

import com.epam.factory.AbstractIngradientFactory;
import com.epam.liquer.Liqueur;

public interface AbstractLiqueurFromFactoryCreator {

	Liqueur createLiqueur(AbstractIngradientFactory abstractLiqueurFactory);

}
