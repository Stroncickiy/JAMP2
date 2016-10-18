package com.epam.model;


import java.io.Serializable;

public class Ancillary implements Serializable {
    private String name;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
