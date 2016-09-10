package com.epam.ingradient;


public abstract class Product {
    public abstract int getBaseAmmount();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
