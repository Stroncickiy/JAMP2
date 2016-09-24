package com.epam.chainofresponsibility;

public class ExteriorFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		if (!buildType.equals(BuildType.AMBAR)) {
			System.out.println(" exterior designed for " + buildType);
		}

	}

}
