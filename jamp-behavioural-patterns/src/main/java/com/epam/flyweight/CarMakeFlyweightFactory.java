package com.epam.flyweight;

public interface CarMakeFlyweightFactory {
	int countCarMakeFlyweight(String key);

	void registerCar(CarMakeFlyweight carMakeFlyweight);

	void registerAction(CarMakeContext carMakeContext);
}
