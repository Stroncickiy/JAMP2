package com.epam.model;


import java.io.Serializable;

public class LuggageAllowance implements Serializable {
    private int kgAllowed;
    private int costOfKg;


    public int getKgAllowed() {
        return kgAllowed;
    }

    public void setKgAllowed(int kgAllowed) {
        this.kgAllowed = kgAllowed;
    }

    public int getCostOfKg() {
        return costOfKg;
    }

    public void setCostOfKg(int costOfKg) {
        this.costOfKg = costOfKg;
    }
}
