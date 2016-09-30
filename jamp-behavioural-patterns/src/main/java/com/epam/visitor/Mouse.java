package com.epam.visitor;

public class Mouse implements ComputerElement {

	@Override
	public boolean isAcceptable(ActionPerformer actionPerformer) {
		return (actionPerformer instanceof MouseMovementActionPerformer);

	}

	@Override
	public void visit(ActionPerformer actionPerformer) {
		System.out.println(" mouse movement initiated by "+actionPerformer.getClass());
	}

}
