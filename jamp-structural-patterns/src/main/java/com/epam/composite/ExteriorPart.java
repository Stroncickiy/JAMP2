package com.epam.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ExteriorPart {
	private ExteriorPart parent;
	private List<ExteriorPart> childs;

	public ExteriorPart() {
		childs = new ArrayList<>();
	}

	public void plant() {
		System.out.format("Garden part %s is  %s ", getClass().getSimpleName(), ((parent == null)? " root element ": " child of "+ parent.getClass().getSimpleName() ));
		System.out.format(" has  %s ", (childs.size() == 0 ? " no childs  " : childs.size() + " childs"));
		for (ExteriorPart exteriorPart : childs) {
			System.out.println("\t ");
			exteriorPart.plant();
		}
		System.out.println();
	}

	public void add(ExteriorPart part) {
		part.setParent(this);
		childs.add(part);
	}

	private void setParent(ExteriorPart exteriorPart) {
		this.parent = exteriorPart;

	}

	public void remove(ExteriorPart part) {
		childs.remove(part);
	}

	public ExteriorPart getChild(int index) {
		return childs.get(index);
	}

}
