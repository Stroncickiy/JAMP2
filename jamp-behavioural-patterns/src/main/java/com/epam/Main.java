package com.epam;

public class Main {
	public static void main(String[] args) {
		System.out.println("== ChainOfResponsibility  Sample  ==");
		ChainOfResponsibilitySample.exec();

		System.out.println("==  Command sample ==");
		CommandSample.exec();

		System.out.println("== Interpreter sample ==");
		InterpreterSample.exec();

		System.out.println("== Iterator sample == ");
		IteratorSample.exec();

		System.out.println("== State sample ==");
		StateSample.exec();

		System.out.println(" == Observer sample ==");
		ObserverSample.exec();

		System.out.println("== Memento sample == ");
		MementoSample.exec();

		System.out.println(" == Strategy Sample == ");
		StrategySample.exec();

		System.out.println("== Mediator sample ==");
		MediatorSample.exec();

	}
}
