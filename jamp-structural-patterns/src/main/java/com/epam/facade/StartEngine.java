package com.epam.facade;

public class StartEngine implements Accumulator, Engine, FuelSystem, Transmission, Wheels {

	public void startEngine() {
		applyVoltage();
		supplyFuel();
		startCylinders();
		changeGear();
		move();
	}

	@Override
	public void move() {
		System.out.println(" wheels started to move");

	}

	@Override
	public void changeGear() {
		System.out.println(" gear changed ");

	}

	@Override
	public void supplyFuel() {
		System.out.println(" fuel supplied ");

	}

	@Override
	public void startCylinders() {
		System.out.println(" cylinders stated ");

	}

	@Override
	public void applyVoltage() {
		System.out.println(" voltage applied ");

	}

}
