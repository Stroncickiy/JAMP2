package com.epam.chainofresponsibility;

public class FurnitureFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		if (!buildType.equals(BuildType.AMBAR)) {
			System.out.println(" building  " + buildType + " was supplied with furniture");
		}
	}

}
