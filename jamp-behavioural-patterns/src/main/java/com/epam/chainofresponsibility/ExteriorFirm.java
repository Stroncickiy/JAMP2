package com.epam.chainofresponsibility;

public class ExteriorFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println(" exterior designed for " + buildType);

	}

}
