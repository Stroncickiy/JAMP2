package com.epam.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class ConstructionFirm {

	private List<SubordinateFirm> childFirms;

	public ConstructionFirm() {
		childFirms = new ArrayList<>();
	}

	public void addSubordinateFirm(SubordinateFirm subordinateFirm) {
		childFirms.add(subordinateFirm);
	}

	public void handleClientRequest(BuildType buildType) {
		for (SubordinateFirm subordinateFirm : childFirms) {
			subordinateFirm.handle(buildType);
		}
	}
}
