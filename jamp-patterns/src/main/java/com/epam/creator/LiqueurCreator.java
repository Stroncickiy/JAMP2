package com.epam.creator;

import com.epam.factory.AbstractProductFactory;
import com.epam.ingradient.Product;
import com.epam.liquer.Liqueur;
import com.epam.reciept.Ingredient;
import com.epam.reciept.Receipt;

import java.util.List;


public class LiqueurCreator extends AbstractLiqueurCreator {
    @Override
    public Liqueur createLiqueur(AbstractProductFactory abstractLiqueurFactory, Receipt receipt) {
        Liqueur liqueur = new Liqueur();
        List<Ingredient> ingredients = receipt.getIngredients();
        for (Ingredient ingredient : ingredients){
            Class<? extends Product> productClass = ingredient.getProduct();
            Product product  = abstractLiqueurFactory.createProduct(productClass);
            liqueur.addProduct(product, ingredient.getMultiplier());
        }
        return liqueur;
    }
}
