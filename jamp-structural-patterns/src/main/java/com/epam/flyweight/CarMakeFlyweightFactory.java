package com.epam.flyweight;

public interface CarMakeFlyweightFactory {
	int countCarMakeFlyweight(String key);

	void registerAction(CarMakeContext carMakeContext);
}
