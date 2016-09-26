package com.epam;

import com.epam.memento.Shop;

public class MementoSample {
	public static void exec() {
		Shop shop = new Shop("backupOfOffer");
		shop.createOffer(123, "I want in red collor");
		
		shop.printUserOfferStatus();
		shop.saveOffer();

		shop.updateOfferComment(" I'm sorry I changed  my mind, I want in blue! ");
		shop.printUserOfferStatus();

		shop.rollbackOffer();
		shop.printUserOfferStatus();

	}
}
