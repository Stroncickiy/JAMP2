package com.epam.strategy;

public class TwoSidesAndRightAngleStrategy implements AreaCalculationStrategy {

	@Override
	public double calculateArea(Triangle triangle) {
		return (triangle.getKatet1() * triangle.getKatet2()) / 2;
	}

}
