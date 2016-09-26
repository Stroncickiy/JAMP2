package com.epam.memento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Random;

public class Shop {
	private ObjectOutputStream fileOutputStream;
	private ObjectInputStream fileInputStream;
	private File backupFile;
	private Offer userOffer;
	private OfferDataKeeper offerDataKeeper;

	public Shop(String backupFileName) {
		backupFile = new File(backupFileName);
		try {
			fileOutputStream = new ObjectOutputStream(new FileOutputStream(backupFile));
			fileInputStream = new ObjectInputStream(new FileInputStream(backupFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public void printUserOfferStatus() {
		System.out.println("current offer state " + userOffer);
	}

	public void updateOfferProductId(int newProductId) {
		offerDataKeeper.setProductId(newProductId);
		userOffer.updateData(offerDataKeeper);
	}
	
	public void updateOfferComment(String newComment) {
		offerDataKeeper.setComment(newComment);
		userOffer.updateData(offerDataKeeper);
	}

	public void createOffer(int productId, String comment) {
		Offer offer = new Offer();
		offer.setComment(comment);
		offer.setProductId(productId);
		offer.setDateCreated(new Date());
		offer.setLastUpdateDate(new Date());
		offer.setOfferId(new Random().nextInt(100));
		userOffer = offer;
		offerDataKeeper = new OfferDataKeeper();
		offerDataKeeper.setComment(comment);
		offerDataKeeper.setProductId(productId);
	}

	public void rollbackOffer() {
		OfferDataKeeper dataKeeper = null;
		try {
			dataKeeper = (OfferDataKeeper) fileInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		if (dataKeeper != null) {
			System.out.println(" offer was rollbacked with following data " + dataKeeper);
			this.offerDataKeeper= dataKeeper;
			userOffer.updateData(dataKeeper);
		}
	}

	public void saveOffer() {
		System.out.println(" saving offer data " + offerDataKeeper);
		try {
			fileOutputStream.writeObject(offerDataKeeper);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
