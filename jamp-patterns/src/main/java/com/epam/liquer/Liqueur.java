package com.epam.liquer;


import com.epam.ingradient.Product;
import com.epam.reciept.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Liqueur {
    private List<Ingredient> products;

    public Liqueur() {
        this.products = new ArrayList<>();
    }

    public List<Ingredient> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "Liqueur{" +
                "products=" + products +
                '}';
    }

    public void addProduct(Product product, int multiplier) {
        products.add(new Ingredient(product.getClass(),product.getBaseAmmount()*multiplier));
    }


}
