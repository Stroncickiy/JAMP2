package com.epam.visitor;

public class Screen implements ComputerElement {

	@Override
	public boolean isAcceptable(ActionPerformer actionPerformer) {
		return actionPerformer instanceof ShowMovieOnScreenActionPerformer;
	}

	@Override
	public void visit(ActionPerformer actionPerformer) {
		System.out.println(" screen showing initiated by "+actionPerformer.getClass());

	}

}
