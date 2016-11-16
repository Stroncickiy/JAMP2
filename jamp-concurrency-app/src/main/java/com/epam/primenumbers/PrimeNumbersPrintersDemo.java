package com.epam.primenumbers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeNumbersPrintersDemo {
	public void run() throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(6);
		System.out.println(" prime numbers printers (runnable) ");

		executor.execute(new PrimeNumbersPrinter(100));
		executor.execute(new PrimeNumbersPrinter(1000));
		executor.execute(new PrimeNumbersPrinter(10000));

		System.out.println(" prime numbers sumators (runnable) ");

		Future<Integer> sumOfPrimeNumbersUpTo100Future = executor.submit(new PrimeNumbersCallableSummator(100));
		Future<Integer> sumOfPrimeNumbersUpTo1000Future = executor.submit(new PrimeNumbersCallableSummator(1000));
		Future<Integer> sumOfPrimeNumbersUpTo10000Future = executor.submit(new PrimeNumbersCallableSummator(10000));

		Integer sumOfPrimeNumbersUpTo100 = sumOfPrimeNumbersUpTo100Future.get();
		Integer sumOfPrimeNumbersUpTo1000 = sumOfPrimeNumbersUpTo1000Future.get();
		Integer sumOfPrimeNumbersUpTo10000 = sumOfPrimeNumbersUpTo10000Future.get();

		System.out.println(" sum of prime numbers less than 100 = " + sumOfPrimeNumbersUpTo100);
		System.out.println(" sum of prime numbers less than 1000 = " + sumOfPrimeNumbersUpTo1000);
		System.out.println(" sum of prime numbers less than 10000 = " + sumOfPrimeNumbersUpTo10000);
		
		executor.shutdown();
	}
}
