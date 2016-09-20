package com.epam;

import com.epam.chainofresponsibility.BuildType;
import com.epam.chainofresponsibility.ConstructionFirm;
import com.epam.chainofresponsibility.RepairFirm;

public class ChainOfResponsibilitySample {

	public static void exec() {

		ConstructionFirm constructionFirm = new ConstructionFirm();
		constructionFirm.addSubordinateFirm(new RepairFirm());
		constructionFirm.handleClientRequest(BuildType.AMBAR);

	}

}
