package com.epam.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			String msg = retrieveMessageWithTimeout();
			while (msg != null) {
				System.out.println(msg);
				msg = retrieveMessageWithTimeout();
			}
			System.out.println("No more messages available, consumer will stop it's work... ");
		} catch (InterruptedException e) {
			System.out.println("Error occured whule retrieving messages");
		}

	}

	private String retrieveMessageWithTimeout() throws InterruptedException {
		return queue.poll(1000L, TimeUnit.MILLISECONDS);
	}
}