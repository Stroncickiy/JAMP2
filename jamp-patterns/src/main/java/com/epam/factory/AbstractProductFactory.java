package com.epam.factory;


import com.epam.ingradient.*;

public abstract class AbstractProductFactory {


    public abstract Product createProduct(Class<? extends Product> productClass);
}
