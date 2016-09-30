package com.epam.visitor;

public interface ComputerElement {
	boolean isAcceptable(ActionPerformer actionPerformer);

	void visit(ActionPerformer actionPerformer);
}
