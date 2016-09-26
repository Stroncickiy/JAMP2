package com.epam;

import com.epam.iterator.Department;
import com.epam.iterator.Firm;

public class IteratorSample {
	public static void exec() {
		Firm firm = new Firm("<Epam>");
		System.out.println("Firm " + firm + " has such departments");
		for (Department department : firm) {
			System.out.println(department);
		}
	}
}
