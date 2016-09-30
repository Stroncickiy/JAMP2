package com.epam.strategy;

public class ThreeSidesAreaCalculationStrategy implements AreaCalculationStrategy {

	@Override
	public double calculateArea(Triangle triangle) {
		double p = (triangle.getKatet1() + triangle.getKatet2() + triangle.getHypotenuza()) / 2;
		double s = Math
				.sqrt( p * (p - triangle.getKatet1()) * (p - triangle.getKatet2()) * (p - triangle.getHypotenuza()));
		return s;
	}

}
