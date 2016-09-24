package com.epam.flyweight;

public class CarMakeContext {
	private String carMake;
	private ActionType actionType;

	public CarMakeContext(String carMake, ActionType actionType) {
		this.carMake = carMake;
		this.actionType = actionType;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

}
