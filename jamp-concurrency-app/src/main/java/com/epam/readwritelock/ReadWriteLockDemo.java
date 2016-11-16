package com.epam.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLockDemo {

	public void run() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		ReadWriteLock lock = new ReadWriteLock();

		executorService.execute(() -> {
			try {
				lock.lockRead();
				System.out.println("Reader 1 started reading information");
				Thread.sleep(1000); // simulating long read operation
				System.out.println("Reader 1 finished reading information");
			} catch (InterruptedException e) {
			}
			lock.unlockRead();
		});

		executorService.execute(() -> {
			try {
				lock.lockRead();
				System.out.println("Reader 2 started reading information");
				Thread.sleep(1000);
				System.out.println("Reader 2 finished reading information");
			} catch (InterruptedException e) {
			}
			lock.unlockRead();
		});

		executorService.execute(() -> {
			try {
				lock.lockWrite();
				System.out.println("Writer 1 started reading information");
				Thread.sleep(1000); // simulating long write operation
				System.out.println("Writer 1 finished reading information");
				lock.unlockWrite();
			} catch (InterruptedException e) {
			}
		});

		executorService.execute(() -> {
			try {
				lock.lockRead();
				System.out.println("Reader 3 started reading information");
				Thread.sleep(1000);
				System.out.println("Reader 3 finished reading information");
			} catch (InterruptedException e) {
			}
			lock.unlockRead();
		});

		executorService.execute(() -> {
			try {
				lock.lockWrite();
				System.out.println("Writer 2 started reading information");
				Thread.sleep(1000);
				System.out.println("Writer 2 finished reading information");
				lock.unlockWrite();
			} catch (InterruptedException e) {
			}
		});
	}

}
