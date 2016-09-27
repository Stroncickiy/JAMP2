package com.epam.visitor;

public class KeyboardPrinterActionPerformer implements ActionPerformer {

	@Override
	public void performAction(Computer computer) {
		computer.useKeyboard(10);
		computer.useKeyboard(12);
		computer.useKeyboard(13);
		computer.useKeyboard(14);
		computer.useKeyboard(15);

	}

}
