package com.epam.adapter;

public class ManualToAutomaticAdapter implements AutomaticTransmission {

	private ManualTransmission manualTransmission;

	public ManualToAutomaticAdapter(ManualTransmission manualTransmission) {
		this.manualTransmission = manualTransmission;
	}

	@Override
	public void gearUp() {
		int currentGear = manualTransmission.getGear();
		switch (currentGear) {
		case -1:
			manualTransmission.neutralGear();
			break;
		case 0:
			manualTransmission.firstGear();
			break;
		case 1:
			manualTransmission.secondGear();
			break;
		case 2:
			manualTransmission.thirdGear();
			break;
		case 3:
			manualTransmission.fourthGear();
			break;
		default:
			System.out.println("max gear reached " + currentGear);
			break;
		}

	}

	@Override
	public void gearDown() {
		int currentGear = manualTransmission.getGear();
		switch (currentGear) {
		case -1:
			System.out.println("min gear reached " + currentGear);
			break;
		case 0:
			manualTransmission.backGear();
			break;
		case 1:
			manualTransmission.neutralGear();
			break;
		case 2:
			manualTransmission.firstGear();
			break;
		case 3:
			manualTransmission.secondGear();
			break;
		case 4:
			manualTransmission.thirdGear();
			break;
		}
	}

}
