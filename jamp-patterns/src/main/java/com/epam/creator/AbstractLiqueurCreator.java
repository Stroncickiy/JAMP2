package com.epam.creator;

import com.epam.factory.AbstractProductFactory;
import com.epam.liquer.Liqueur;
import com.epam.reciept.Receipt;


public abstract class AbstractLiqueurCreator {
    public abstract Liqueur createLiqueur(AbstractProductFactory abstractLiqueurFactory, Receipt receipt);
}
