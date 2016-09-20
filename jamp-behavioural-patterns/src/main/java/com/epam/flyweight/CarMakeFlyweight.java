package com.epam.flyweight;

public abstract class CarMakeFlyweight {
	protected String identifier;
	protected int count;

	public void recalculate(CarMakeContext context) {
		if (context.getActionType().equals(ActionType.ARRIVAL)) {
			count++;
		} else if (count > 0) {
			count--;
		}
	}

	public int getCount() {
		return count;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
