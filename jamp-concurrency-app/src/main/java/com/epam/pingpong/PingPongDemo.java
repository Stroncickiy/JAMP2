package com.epam.pingpong;

public class PingPongDemo {

	private static final String TURN_1_NAME = "ping";
	private static final String TUNR_2_NAME = "pong";
	private Table controller = new Table(10);

	public void run() throws InterruptedException {

		Turn ping = controller.createTurn(TURN_1_NAME);
		Turn pong = controller.createTurn(TUNR_2_NAME);

		startTurn(ping);
		startTurn(pong);

		Thread.sleep(100L);

		synchronized (controller) {
			controller.notify();
		}

	}

	private void startTurn(Turn ping) {
		new Thread(ping).start();
	}

}
