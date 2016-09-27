package com.epam.visitor;

public class MouseMovementActionPerformer implements ActionPerformer {

	@Override
	public void performAction(Computer computer) {
		computer.useMouse(0, 0, 10, 10);
		computer.useMouse(0, 0, 11, 11);
		computer.useMouse(0, 0, 12, 12);
		computer.useMouse(0, 0, 13, 13);
	}

}
