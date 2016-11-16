package com.epam.primenumbers;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class PrimeNumbersCallableSummator extends PrimeNumersEvaluator implements Callable<Integer> {

	public PrimeNumbersCallableSummator(int n) {
		super(n);
	}

	@Override
	public Integer call() throws Exception {
		findPrimeNumbers();
		return IntStream.of(sequence).sum();
	}

}
