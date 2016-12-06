package com.epam.pingpong;

public class Table {

	private int numberOfTurns;
	private int currentNumberOfTurns;

	public Table(int turns) {
		this.numberOfTurns = turns;
		this.currentNumberOfTurns = turns;
	}

	public synchronized void performTurn(String turn) {
		this.currentNumberOfTurns--;
		System.out.println(turn);
	}

	public int getCurrentNumberOfTurns() {
		return currentNumberOfTurns;
	}

	public Turn createTurn(String turnName) {
		return new Turn(turnName, this);
	}

	public int getOriginalNumberOfTurns() {
		return numberOfTurns;
	}

}
