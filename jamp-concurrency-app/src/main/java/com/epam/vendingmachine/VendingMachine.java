package com.epam.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendingMachine {
	private List<Object> objectsToSynchronizeOnIn3Methods = new ArrayList<>(3);

	public VendingMachine(boolean synchronizeOnTheSameObject) {
		if (synchronizeOnTheSameObject) {
			objectsToSynchronizeOnIn3Methods.add(this);
			objectsToSynchronizeOnIn3Methods.add(this);
			objectsToSynchronizeOnIn3Methods.add(this);
		} else {
			objectsToSynchronizeOnIn3Methods.add(new Object());
			objectsToSynchronizeOnIn3Methods.add(new Object());
			objectsToSynchronizeOnIn3Methods.add(new Object());

		}
	}

	public void buyGoods(String username, String goodsName, int count) {
		synchronized (objectsToSynchronizeOnIn3Methods.get(0)) {
			System.out.format(" user %s started to buy %d %s  \n", username, count, goodsName);
			int timeOfAction = new Random().nextInt(1000);
			try {
				Thread.sleep(timeOfAction);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.format(" user %s finished to buy %d %s  after %d miliseconds \n", username, count, goodsName,
					timeOfAction);
		}
	}

	public void loadNewGoods(String adminName, String goodsName, int count) {
		synchronized (objectsToSynchronizeOnIn3Methods.get(1)) {
			System.out.format(" admin %s started to load %d  new goods %s to machine \n", adminName, count, goodsName);
			int timeOfAction = new Random().nextInt(1000);
			try {
				Thread.sleep(timeOfAction);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.format(" admin %s finished to load %d  new goods %s to machine after %d miliseconds  \n",
					adminName, count, goodsName, timeOfAction);
		}
	}

	public synchronized void cleanMachine(String cleanerName) {
		synchronized (objectsToSynchronizeOnIn3Methods.get(2)) {
			System.out.format(" cleaner %s started to clean machine \n", cleanerName);
			int timeOfAction = new Random().nextInt(1000);
			try {
				Thread.sleep(timeOfAction);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.format(" cleaner %s finished to clean machine after %d miliseconds \n", cleanerName,
					timeOfAction);
		}
	}

}
