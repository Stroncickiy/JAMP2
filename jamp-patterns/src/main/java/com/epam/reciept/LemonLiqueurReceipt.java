package com.epam.reciept;


import com.epam.ingradient.Eggs;
import com.epam.ingradient.Limon;
import com.epam.ingradient.Vodka;
import com.epam.ingradient.Water;

public class LemonLiqueurReceipt extends Receipt {
    @Override
    public void constructReceipt() {
        ingredients.add(new Ingredient(Eggs.class,10));
        ingredients.add(new Ingredient(Water.class,9));
        ingredients.add(new Ingredient(Limon.class,2));
        ingredients.add(new Ingredient(Vodka.class,3));

    }
}
