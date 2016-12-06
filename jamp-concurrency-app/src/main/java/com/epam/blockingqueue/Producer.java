package com.epam.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			produceMessages("1", "2", "3", "4");
		} catch (InterruptedException e) {
			System.out.println("Error occred while producing messages.. ");
		}

	}

	private void produceMessages(String... msgs) throws InterruptedException {
		for (String msg : msgs) {
			putMessage(msg);
		}

	}

	private void putMessage(String msg) throws InterruptedException {
		queue.put(msg);
		Thread.sleep(1000);
	}
}