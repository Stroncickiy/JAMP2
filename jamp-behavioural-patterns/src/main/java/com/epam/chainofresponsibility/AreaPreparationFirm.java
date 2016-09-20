package com.epam.chainofresponsibility;

public class AreaPreparationFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println("Area prepared for " + buildType);

	}

}
