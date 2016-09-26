package com.epam.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Firm implements Iterator<Department>, Iterable<Department> {
	private String name;
	private Department hrDepartment = new Department("HR Department");
	private Department itDepartment = new Department("IT Department");
	private Department serviceStuffDepartment = new Department("Service stuff Department");
	private Department currentDepartment;

	public Firm(String name) {
		this.name = name;
	}

	public boolean hasNext() {
		return !serviceStuffDepartment.equals(currentDepartment);
	}

	public Department next() {
		if (currentDepartment == null) {
			currentDepartment = hrDepartment;
		} else if (currentDepartment.equals(hrDepartment)) {
			currentDepartment = itDepartment;
		} else if (currentDepartment.equals(itDepartment)) {
			currentDepartment = serviceStuffDepartment;
		} else if (currentDepartment.equals(serviceStuffDepartment)) {
			throw new NoSuchElementException(" there is no departments");
		}
		return currentDepartment;
	}

	@Override
	public Iterator<Department> iterator() {
		return this;
	}

	@Override
	public String toString() {
		return "Firm [name=" + name + "]";
	}

}
