package com.epam.visitor;

import java.util.ArrayList;
import java.util.List;

public class Computer {

	private List<ComputerElement> elements = new ArrayList<>();

	public Computer() {
		elements.add(new Mouse());
		elements.add(new Screen());
		elements.add(new Keyboard());
	}

	public void acceptActionPerformer(ActionPerformer visitor) {
		for (ComputerElement computerElement : elements) {
			if (computerElement.isAcceptable(visitor)) {
				computerElement.visit(visitor);
			}
		}
	}

}
