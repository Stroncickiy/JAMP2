package com.epam;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		System.out.println("== Adapter sample ==");
		AdapterSample.exec();

		System.out.println("== Bridge sample == ");
		BridgeSample.exec();

		System.out.println("== Composite sample ==");
		CompositeSample.exec();

		System.out.println("== Facade sample ==");
		FacadeSample.exec();

		System.out.println("== Decorator sample ==");
		try {
			DecoratorSample.exec();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("== Proxy sample == ");
		ProxySample.exec();

		System.out.println(" == Flyweight sample ==");
		FlyweightSample.exec();

	}
}
