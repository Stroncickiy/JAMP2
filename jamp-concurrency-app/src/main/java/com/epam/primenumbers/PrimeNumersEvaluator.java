package com.epam.primenumbers;

import java.util.Arrays;

//implementer according to Sieve of Eratosthenes
public class PrimeNumersEvaluator {
	private int n;
	protected int[] sequence;

	public PrimeNumersEvaluator(int n) {
		this.n = n;
		this.sequence = new int[n];
	}

	protected void findPrimeNumbers() {
		for (int i = 0; i < n; i++) {
			sequence[i] = i;
		}
		markNonPrimeNumbers(sequence, 2);

		sequence = Arrays.stream(sequence).filter(x -> x > 2).toArray();

	}

	private void markNonPrimeNumbers(int[] sequenceToFilter, int p) {
		for (int i = 2 * p; i < sequenceToFilter.length; i += p) {
			sequenceToFilter[i] = -1;
		}

		int nextP = -1;
		for (int i = p + 1; i < sequenceToFilter.length; i++) {
			if (sequenceToFilter[i] > p) {
				nextP = sequenceToFilter[i];
				break;
			}
		}
		if (nextP != -1) {
			markNonPrimeNumbers(sequenceToFilter, nextP);
		}
	}
}
