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

	@Override
	public void registerCar(CarMakeFlyweight carMakeFlyweight) {
		cars.put(carMakeFlyweight.getIdentifier(), carMakeFlyweight);
	}

	public void registerAction(CarMakeContext carMakeContext) {
		cars.get(carMakeContext.getCarMake()).recalculate(carMakeContext);
	}
}
