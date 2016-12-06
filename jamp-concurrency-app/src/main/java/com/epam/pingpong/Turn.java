package com.epam.pingpong;

public class Turn implements Runnable {
	private static final int TIMEOUT = 100;
	private String turnName;
	private Table controller;

	public Turn(String turnName, Table controller) {
		this.turnName = turnName;
		this.controller = controller;
	}

	public void run() {
		synchronized (controller) {
			while (controller.getCurrentNumberOfTurns() > 0) {
				try {
					controller.wait();
					controller.performTurn(turnName);
					controller.wait(TIMEOUT);
				} catch (InterruptedException e) {
					System.out.format("Error occured while performing turn %s", turnName);
				}
				controller.notify();
			}
			System.out.format("All %s turn were performed, %s will stop it's work ... \n ",
					controller.getOriginalNumberOfTurns(), turnName);
		}

	}

}
