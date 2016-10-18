package com.epam.model;


import java.io.Serializable;
import java.util.List;

public class Ancillaries implements Serializable {
    private List<Ancillary> availableAncillaries;

    public List<Ancillary> getAvailableAncillaries() {
        return availableAncillaries;
    }

    public void setAvailableAncillaries(List<Ancillary> availableAncillaries) {
        this.availableAncillaries = availableAncillaries;
    }
}
