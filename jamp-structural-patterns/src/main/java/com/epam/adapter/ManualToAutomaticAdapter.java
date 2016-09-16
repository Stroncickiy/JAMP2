package com.epam.adapter;

public class ManualToAutomaticAdapter implements AutomaticTransmission {

	private ManualTransmission manualTransmission;

	public ManualToAutomaticAdapter(ManualTransmission manualTransmission) {
		this.setManualTransmission(manualTransmission);
	}

	@Override
	public void gearUp() {
		int currentGear = getManualTransmission().getGear();
		switch (currentGear) {
		case -1:
			getManualTransmission().neutralGear();
			break;
		case 0:
			getManualTransmission().firstGear();
			break;
		case 1:
			getManualTransmission().secondGear();
			break;
		case 2:
			getManualTransmission().thirdGear();
			break;
		case 3:
			getManualTransmission().fourthGear();
			break;
		case 4:
			System.out.println("max gear reached " + currentGear);
			break;
		}

	}

	@Override
	public void gearDown() {
		int currentGear = getManualTransmission().getGear();
		switch (currentGear) {
		case -1:
			System.out.println("min gear reached " + currentGear);
			break;
		case 0:
			getManualTransmission().backGear();
			break;
		case 1:
			getManualTransmission().neutralGear();
			break;
		case 2:
			getManualTransmission().firstGear();
			break;
		case 3:
			getManualTransmission().secondGear();
			break;
		case 4:
			getManualTransmission().thirdGear();
			break;
		}
	}

	public ManualTransmission getManualTransmission() {
		return manualTransmission;
	}

	public void setManualTransmission(ManualTransmission manualTransmission) {
		this.manualTransmission = manualTransmission;
	}

}
