package com.epam.model;


public class BookingInfo {
    private Ancillaries availableAncillaries;
    private LuggageAllowance luggageAllowance;

    public Ancillaries getAvailableAncillaries() {
        return availableAncillaries;
    }

    public void setAvailableAncillaries(Ancillaries availableAncillaries) {
        this.availableAncillaries = availableAncillaries;
    }

    public LuggageAllowance getLuggageAllowance() {
        return luggageAllowance;
    }

    public void setLuggageAllowance(LuggageAllowance luggageAllowance) {
        this.luggageAllowance = luggageAllowance;
    }
}
