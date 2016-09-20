package com.epam.chainofresponsibility;

public class RepairFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println(" build type " + buildType + " was handled by RepairFirm");

	}

}
