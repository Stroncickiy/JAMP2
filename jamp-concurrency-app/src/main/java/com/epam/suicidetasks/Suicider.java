package com.epam.suicidetasks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Suicider implements Runnable {

	private int index;

	public Suicider(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		System.out.format(" Uiiii, I'm  %d What a beautiful life.. \n ", index);
		int ttl = new Random().nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(ttl);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.format(
				" Ohh, I was supposed to live a long life, but unfortunately I have to go to better place  %d seconds was enough for me to understand that I'm redundant in here... \n",
				ttl);
	}

}
