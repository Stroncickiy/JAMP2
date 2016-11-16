package com.epam.suicidetasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SuicideTasksDemo {
	private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
	private Random random = new Random();
	private int countOfSuiciders;

	public SuicideTasksDemo(int countOfSuiciders) {
		this.countOfSuiciders = countOfSuiciders;
	}

	public void run() throws InterruptedException, ExecutionException {
		System.out.format(" Scheduler is about to produce %d suiciders \n", countOfSuiciders);
		List<ScheduledFuture<?>> futures = new ArrayList<>();
		for (int i = 1; i <= countOfSuiciders; i++) {
			int ttc = random.nextInt(20);
			System.out.format("Suicider %d will be alive after %d seconds \n", i, ttc);
			futures.add(executorService.schedule(new Suicider(i), ttc, TimeUnit.SECONDS));
		}
		for (ScheduledFuture<?> scheduledFuture : futures) {
			scheduledFuture.get();
		}
		System.out.println("All suiciders died.. ");
	}
}
