package com.epam.reciept;


import com.epam.ingradient.Product;

public class Ingredient {
    private Class<? extends  Product> product;
    private int multiplier;

    public Ingredient(Class<? extends Product> productClass, int multiplier) {
        product = productClass;
        this.multiplier = multiplier;
    }


    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public Class<? extends Product> getProduct() {
        return product;
    }

    public void setProduct(Class<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "product=" + product +
                ", multiplier=" + multiplier +
                '}';
    }
}
