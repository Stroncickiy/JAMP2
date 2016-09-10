package com.epam.reciept;


import java.util.ArrayList;
import java.util.List;

public abstract class Receipt {
    protected List<Ingredient> ingredients;

    public Receipt() {
        ingredients = new ArrayList<>();
        constructReceipt();
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public abstract void constructReceipt();
}
