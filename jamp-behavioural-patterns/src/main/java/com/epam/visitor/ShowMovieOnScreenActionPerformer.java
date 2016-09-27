package com.epam.visitor;

public class ShowMovieOnScreenActionPerformer implements ActionPerformer {

	@Override
	public void performAction(Computer computer) {
		computer.showOnScreen("movie");
	}

}
