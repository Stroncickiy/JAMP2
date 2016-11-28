package com.epam.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizationDemo {
	private ExecutorService executorService;

	public void run() throws InterruptedException, ExecutionException {
		executorService = Executors.newFixedThreadPool(10);
		similateActionsWithVendingMachine(true);
		similateActionsWithVendingMachine(false);
		executorService.shutdown();
	}

	private void similateActionsWithVendingMachine(boolean needSynchronize)
			throws InterruptedException, ExecutionException {

		List<Future<?>> futures = new ArrayList<>();
		System.out.format("=====  Demo of simultanous access to vending machine with%s synchronization \n ",
				needSynchronize ? "" : "out");

		VendingMachine machine = new VendingMachine(needSynchronize);

		// run 4 action in different threads

		futures.add(executorService.submit(() -> {
			machine.buyGoods("Bob", "Sneakers", 2);
		}));

		futures.add(executorService.submit(() -> {
			machine.buyGoods("Alice", "Fanta", 1);
		}));
		futures.add(executorService.submit(() -> {
			machine.cleanMachine("Maria Sergeevna");
		}));

		futures.add(executorService.submit(() -> {
			machine.loadNewGoods("Ivan Petrovich", "Fanta", 1);
		}));

		// wait for all actions
		for (Future<?> future : futures) {
			future.get();
		}
	}
}
