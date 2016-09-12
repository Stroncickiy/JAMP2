package com.epam.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class GardenPart {
	private GardenPart parent;
	private List<GardenPart> childs;

	public GardenPart() {
		childs = new ArrayList<>();
	}

	public void plant() {
		System.out.println("Garden part " + getClass().getSimpleName() + " is  " + ((parent == null)
				? " root element ": " child of "+ parent.getClass().getSimpleName() ));
		System.out.println(" has " + (childs.size() == 0 ? " no childs  " : childs.size() + " childs"));
		for (GardenPart gardenPart : childs) {
			System.out.println("\t ");
			gardenPart.plant();
		}
		System.out.println();
	}

	public void add(GardenPart part) {
		part.setParent(this);
		childs.add(part);
	}

	private void setParent(GardenPart gardenPart) {
		this.parent = gardenPart;

	}

	public void remove(GardenPart part) {
		childs.remove(part);
	}

	public GardenPart getChild(int index) {
		return childs.get(index);
	}

}
