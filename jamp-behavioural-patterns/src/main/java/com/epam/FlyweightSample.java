package com.epam;

import com.epam.flyweight.ActionType;
import com.epam.flyweight.Bmw;
import com.epam.flyweight.CarMakeContext;
import com.epam.flyweight.CarMakeFlyweight;
import com.epam.flyweight.CarMakeFlyweightFactory;
import com.epam.flyweight.Ford;
import com.epam.flyweight.SimpleCarMakeFactory;

public class FlyweightSample {
	private static final String BMW_IDENTIFIER = "BMW";
	private static final String FORD_IDENTIFIER = "FORD";

	public static void exec() {
		CarMakeFlyweightFactory carMakeFlyweightFactory = new SimpleCarMakeFactory();
		
		CarMakeFlyweight bmw = new Bmw(BMW_IDENTIFIER);
		CarMakeFlyweight ford = new Ford(FORD_IDENTIFIER);

		carMakeFlyweightFactory.registerCar(bmw);
		carMakeFlyweightFactory.registerCar(ford);

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
