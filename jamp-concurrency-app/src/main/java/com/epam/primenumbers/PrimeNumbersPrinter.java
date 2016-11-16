package com.epam.primenumbers;

import java.util.Arrays;


public class PrimeNumbersPrinter extends PrimeNumersEvaluator implements Runnable {

	public PrimeNumbersPrinter(int n) {
		super(n);
	}

	@Override
	public void run() {
		findPrimeNumbers();
		System.out.println(Arrays.toString(sequence));
	}
}
