package com.epam.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SimpleCarMakeFactory implements CarMakeFlyweightFactory {

	private Map<String, CarMakeFlyweight> cars;

	public SimpleCarMakeFactory() {
		cars = new HashMap<>();
	}

	@Override
	public int countCarMakeFlyweight(String key) {
		return ((CarMakeFlyweight) cars.get(key)).getCount();
	}

	public void registerAction(CarMakeContext carMakeContext) {
		if (!cars.containsKey(carMakeContext.getCarMake())) {
			cars.put(carMakeContext.getCarMake(), createFlyWeight(carMakeContext.getCarMake()));
		}
		cars.get(carMakeContext.getCarMake()).recalculate(carMakeContext);
	}

	private CarMakeFlyweight createFlyWeight(String carMake) {
		switch (carMake) {
		case "Bmw":
			return new Bmw(carMake);
		case "Ford":
			return new Ford(carMake);

		}
		return null;
	}
}
