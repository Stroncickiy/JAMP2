package com.epam.visitor;

public class Keyboard implements ComputerElement {

	@Override
	public boolean isAcceptable(ActionPerformer actionPerformer) {
		return actionPerformer instanceof KeyboardPrinterActionPerformer;
	}

	@Override
	public void visit(ActionPerformer actionPerformer) {
		System.out.println(" keyboard action initiated by " + actionPerformer.getClass());

	}

}
