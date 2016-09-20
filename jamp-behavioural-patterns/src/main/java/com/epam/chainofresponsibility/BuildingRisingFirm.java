package com.epam.chainofresponsibility;

public class BuildingRisingFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println(" walls rised for " + buildType);

	}

}
