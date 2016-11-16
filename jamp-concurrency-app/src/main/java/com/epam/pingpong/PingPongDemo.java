package com.epam.pingpong;

public class PingPongDemo {

	public void run() throws InterruptedException {

		Table controller = new Table(100);

		Turn ping = new Turn("ping", controller);
		Turn pong = new Turn("pong", controller);

		new Thread(ping).start();
		new Thread(pong).start();

		Thread.sleep(100L);

		synchronized (controller) {
			controller.notify();
		}

	}
}
