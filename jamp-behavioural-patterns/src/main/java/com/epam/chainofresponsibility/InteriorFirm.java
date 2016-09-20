package com.epam.chainofresponsibility;

public class InteriorFirm implements SubordinateFirm {

	@Override
	public void handle(BuildType buildType) {
		System.out.println("Interior designed for "+buildType);

	}

}
