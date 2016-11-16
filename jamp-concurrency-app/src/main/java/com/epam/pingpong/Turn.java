package com.epam.pingpong;

public class Turn implements Runnable {
	private String turnName;
	private Table controller;

	public Turn(String turnName, Table controller) {
		this.turnName = turnName;
		this.controller = controller;
	}

	public void run() {
		synchronized (controller) {
			while (controller.getNumberOfTurns() > 0) {
				try {
					controller.wait();
					controller.performTurn(turnName);
					controller.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				controller.notify();
			}
		}

	}

}
