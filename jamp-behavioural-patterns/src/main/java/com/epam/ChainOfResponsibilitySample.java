package com.epam;

import com.epam.chainofresponsibility.AreaPreparationFirm;
import com.epam.chainofresponsibility.BuildType;
import com.epam.chainofresponsibility.BuildingArchitectireDesignFirm;
import com.epam.chainofresponsibility.BuildingRisingFirm;
import com.epam.chainofresponsibility.ConstructionFirm;
import com.epam.chainofresponsibility.ExteriorFirm;
import com.epam.chainofresponsibility.FurnitureFirm;
import com.epam.chainofresponsibility.InteriorFirm;

public class ChainOfResponsibilitySample {

	public static void exec() {

		ConstructionFirm constructionFirm = new ConstructionFirm();
		
		constructionFirm.addSubordinateFirm(new BuildingArchitectireDesignFirm());
		constructionFirm.addSubordinateFirm(new AreaPreparationFirm());
		constructionFirm.addSubordinateFirm(new BuildingRisingFirm());
		constructionFirm.addSubordinateFirm(new InteriorFirm());
		constructionFirm.addSubordinateFirm(new FurnitureFirm());
		constructionFirm.addSubordinateFirm(new ExteriorFirm());

		
		constructionFirm.handleClientRequest(BuildType.AMBAR);

	}

}
