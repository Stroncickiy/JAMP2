package com.epam.pingpong;

public class Table {

	private int numberOfTurns;

	public Table(int turns) {
		this.numberOfTurns = turns;
	}

	public synchronized void performTurn(String turn) {
		System.out.println(turn);
		numberOfTurns--;
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}
}
