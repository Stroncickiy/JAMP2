package com.epam;

import com.epam.creator.AbstractLiqueurCreator;
import com.epam.creator.LiqueurCreator;
import com.epam.factory.AbstractProductFactory;
import com.epam.factory.ProductFactory;
import com.epam.liquer.Liqueur;
import com.epam.reciept.LemonLiqueurReceipt;
import com.epam.reciept.Receipt;

public class Main {

    public static void main(String[] args) {
        AbstractLiqueurCreator liqueurCreator  = new LiqueurCreator();
        Receipt receipt = new LemonLiqueurReceipt();
        AbstractProductFactory productFactory = new ProductFactory();
        Liqueur liqueur = liqueurCreator.createLiqueur(productFactory, receipt);
        System.out.println(liqueur.toString());
    }
}
