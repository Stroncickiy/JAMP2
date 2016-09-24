package com.epam;

import com.epam.flyweight.ActionType;
import com.epam.flyweight.CarMakeContext;
import com.epam.flyweight.CarMakeFlyweightFactory;
import com.epam.flyweight.SimpleCarMakeFactory;

public class FlyweightSample {
	private static final String BMW_IDENTIFIER = "Bmw";
	private static final String FORD_IDENTIFIER = "Ford";

	public static void exec() {
		CarMakeFlyweightFactory carMakeFlyweightFactory = new SimpleCarMakeFactory();

		CarMakeContext fordArrival = new CarMakeContext(FORD_IDENTIFIER, ActionType.ARRIVAL);
		CarMakeContext fordArrival2 = new CarMakeContext(FORD_IDENTIFIER, ActionType.ARRIVAL);

		CarMakeContext bmwArrival = new CarMakeContext(BMW_IDENTIFIER, ActionType.ARRIVAL);
		CarMakeContext bmwArrival2 = new CarMakeContext(BMW_IDENTIFIER, ActionType.ARRIVAL);
		CarMakeContext bmwDeparture = new CarMakeContext(BMW_IDENTIFIER, ActionType.DEPARTURE);

		carMakeFlyweightFactory.registerAction(fordArrival);
		carMakeFlyweightFactory.registerAction(fordArrival2);

		carMakeFlyweightFactory.registerAction(bmwArrival);
		carMakeFlyweightFactory.registerAction(bmwArrival2);
		carMakeFlyweightFactory.registerAction(bmwDeparture);

		int countOfBmw = carMakeFlyweightFactory.countCarMakeFlyweight(BMW_IDENTIFIER);

		int countOfFord = carMakeFlyweightFactory.countCarMakeFlyweight(FORD_IDENTIFIER);

		System.out.println(" there are " + countOfBmw + " BMW's on parking and " + countOfFord + " Fords also");

	}
}
