package com.epam.factory;


import com.epam.ingradient.Product;

public class ProductFactory extends AbstractProductFactory {


    @Override
    public Product createProduct(Class<? extends Product> productClass) {
        try {
            return productClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
