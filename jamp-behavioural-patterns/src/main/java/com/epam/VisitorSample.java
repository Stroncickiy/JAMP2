package com.epam;

import com.epam.visitor.ActionPerformer;
import com.epam.visitor.Computer;
import com.epam.visitor.KeyboardPrinterActionPerformer;
import com.epam.visitor.MouseMovementActionPerformer;
import com.epam.visitor.ShowMovieOnScreenActionPerformer;

public class VisitorSample {
	public static void exec() {
		Computer computer = new Computer();
		ActionPerformer keyboardActionPerformer = new KeyboardPrinterActionPerformer();
		ActionPerformer mouseActionPerformer = new MouseMovementActionPerformer();
		ActionPerformer showMovieActionPerformer = new ShowMovieOnScreenActionPerformer();

		computer.acceptActionPerformer(keyboardActionPerformer);
		computer.acceptActionPerformer(mouseActionPerformer);
		computer.acceptActionPerformer(showMovieActionPerformer);

	}
}
