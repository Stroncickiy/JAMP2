package com.epam.chainofresponsibility;

public class BuildingArchitectireDesignFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println(" architecture designed for " + buildType);

	}

}
