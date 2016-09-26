package com.epam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.mediator.ATCMediator;
import com.epam.mediator.Plane;

public class MediatorSample {
	public static void exec() {
		ATCMediator airport = new ATCMediator();

		Plane an200 = new Plane(100, "AN200", airport);
		Plane boyeeng400 = new Plane(34, "Boyeeng400", airport);
		Plane boyeeng300 = new Plane(55, "Boyeeng300", airport);

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(an200);
		executorService.submit(boyeeng400);
		executorService.submit(boyeeng300);
		

	}
}
