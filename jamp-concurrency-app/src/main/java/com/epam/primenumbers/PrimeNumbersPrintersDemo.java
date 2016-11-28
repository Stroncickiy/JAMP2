package com.epam.primenumbers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeNumbersPrintersDemo {
	private ExecutorService executor;

	public void run() throws Exception {

		executor = Executors.newFixedThreadPool(6);

		System.out.println(" prime numbers printers (using runnable) ");

		startPrimeNubmersPrinter(100);
		startPrimeNubmersPrinter(1000);
		startPrimeNubmersPrinter(10000);
		
		Thread.sleep(1000L);
		System.out.println(" prime numbers sumators (using callable) ");
		startPrimeNumbersSumator(100);
		startPrimeNumbersSumator(1000);
		startPrimeNumbersSumator(10000);

		executor.shutdown();
	}

	private Future<Integer> startPrimeNumbersSumator(int n) throws InterruptedException, ExecutionException {
		Future<Integer> sumOfPrimeNumbersFuture = executor.submit(new PrimeNumbersCallableSummator(n));
		Integer sumOfPrimeNumbers = sumOfPrimeNumbersFuture.get();
		System.out.format(" sum of prime numbers less than %s = %s \n", n, sumOfPrimeNumbers);
		return sumOfPrimeNumbersFuture;
	}

	private void startPrimeNubmersPrinter(int n) {
		executor.execute(new PrimeNumbersPrinter(n));
	}
}
