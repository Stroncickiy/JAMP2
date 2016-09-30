package com.epam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.epam.memento.Shop;

public class MementoSample {
	public static void exec() {
		String fileName = "backupOfOffer";
		Shop shop = null;
		try {
			File file = new File(fileName);
			FileInputStream inputStream = new FileInputStream(file);
			FileOutputStream outputStream = new FileOutputStream(file);
			shop = new Shop(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (shop != null) {
			shop.createOffer(123, "I want in red collor");

			shop.printUserOfferStatus();
			shop.saveOffer();

			shop.updateOfferComment(" I'm sorry I changed  my mind, I want in blue! ");
			shop.printUserOfferStatus();

			shop.rollbackOffer();
			shop.printUserOfferStatus();
		}

	}
}
