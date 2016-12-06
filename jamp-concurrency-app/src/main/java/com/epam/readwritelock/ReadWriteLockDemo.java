package com.epam.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLockDemo {

	private ExecutorService executorService;

	public void run() {
		executorService = Executors.newFixedThreadPool(10);

		ReadWriteLock lock = new ReadWriteLock();


		startReader(executorService, lock, 1);
		startReader(executorService, lock, 2);
		
		startWriter(executorService, lock, 1);
		
		startReader(executorService, lock, 3);
		startWriter(executorService, lock, 2);
		
		
		executorService.shutdown();
	

	}

	private void startReader(ExecutorService executorService, ReadWriteLock lock, int readerId) {
		executorService.execute(() -> {
			try {
				lock.lockRead();
				System.out.format("Reader %s started reading information \n", readerId);
				Thread.sleep(1000); // simulating long read operation
				System.out.format("Reader %s finished reading information \n ", readerId);
			} catch (InterruptedException e) {
				System.out.format("Error occured while reader %s attemped to access data \n", readerId);
			}
			lock.unlockRead();
		});
	}
	
	private void startWriter(ExecutorService executorService, ReadWriteLock lock, int writerId) {
		executorService.execute(() -> {
			try {
				lock.lockWrite();
				System.out.format("Writer %s started writing information \n", writerId);
				Thread.sleep(1000); // simulating long write operation
				System.out.format("Writer %s finished writing information \n ", writerId);
			} catch (InterruptedException e) {
				System.out.format("Error occured while writer %s attemped to access data \n", writerId);
			}finally {				
				try {
					lock.unlockWrite();
				} catch (InterruptedException e) {
					System.out.println("Error occured while releasing write lock.. \n");
				}
			}
		});
	}

}
