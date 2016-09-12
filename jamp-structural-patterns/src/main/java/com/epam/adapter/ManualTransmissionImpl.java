package com.epam.adapter;

public class ManualTransmissionImpl implements ManualTransmission {

	private int currentGear = 0;

	@Override
	public int getGear() {
		return currentGear;
	}

	@Override
	public void neutralGear() {
		currentGear = 0;
		System.out.println(" neutral gear");

	}

	@Override
	public void firstGear() {
		currentGear = 1;
		System.out.println("first gear");
	}

	@Override
	public void secondGear() {
		currentGear = 2;
		System.out.println("second gear");
	}

	@Override
	public void thirdGear() {
		currentGear = 3;
		System.out.println("third gear");
	}

	@Override
	public void fourthGear() {
		currentGear = 4;
		System.out.println("fourth gear");
	}

	@Override
	public void backGear() {
		currentGear = -1;
		System.out.println("back gear");
	}

}
