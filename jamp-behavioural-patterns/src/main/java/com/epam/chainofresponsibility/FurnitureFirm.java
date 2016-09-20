package com.epam.chainofresponsibility;

public class FurnitureFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println(" building  " + buildType + " was supplied with furniture");

	}

}
