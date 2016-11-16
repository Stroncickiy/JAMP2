package com.epam.vendingmachine;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizationDemo {
	public void run() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		VendingMachine machineThatDisallowsSimultanousAccess = new VendingMachine(true);
		VendingMachine machineThatAllowsSimultanousAccess = new VendingMachine(false);

		System.out.println("=====  Demo of acces to vending machine with synchronization on the same object");

		// run 4 action in different threads
		Future<?> action1Future = executorService.submit(() -> {
			machineThatDisallowsSimultanousAccess.buyGoods("Bob", "Sneakers", 2);
		});
		Future<?> action2Future = executorService.submit(() -> {
			machineThatDisallowsSimultanousAccess.buyGoods("Alice", "Fanta", 1);
		});
		Future<?> action3Future = executorService.submit(() -> {
			machineThatDisallowsSimultanousAccess.cleanMachine("Maria Sergeevna");
		});

		Future<?> action4Future = executorService.submit(() -> {
			machineThatDisallowsSimultanousAccess.loadNewGoods("Ivan Petrovich", "Fanta", 1);
		});

		// wait for all 4 actions
		action1Future.get();
		action2Future.get();
		action3Future.get();
		action4Future.get();

		System.out.println(
				"======== Demo of acces to vending machine with synchronization on different objects, it will be a mess ");

		// run 4 action in different threads
		Future<?> action5Future = executorService.submit(() -> {
			machineThatAllowsSimultanousAccess.buyGoods("Mike", "Lion", 1);
		});
		Future<?> action6Future = executorService.submit(() -> {
			machineThatAllowsSimultanousAccess.buyGoods("Joanne", "Tic Tac", 1);
		});
		Future<?> action7Future = executorService.submit(() -> {
			machineThatAllowsSimultanousAccess.cleanMachine("Maria Sergeevna");
		});

		Future<?> action8Future = executorService.submit(() -> {
			machineThatAllowsSimultanousAccess.loadNewGoods("Ivan Petrovich", "Tic Tac", 1);
		});

		// wait for the rest 4 actions
		action5Future.get();
		action6Future.get();
		action7Future.get();
		action8Future.get();
		executorService.shutdown();
	}
}
