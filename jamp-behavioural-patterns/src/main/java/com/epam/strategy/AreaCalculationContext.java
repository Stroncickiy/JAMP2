package com.epam.strategy;

public class AreaCalculationContext {
	private AreaCalculationStrategy areaCalculationStrategy;

	public AreaCalculationContext(AreaCalculationStrategy strategy) {
		this.areaCalculationStrategy = strategy;
	}

	public double calculateAreaOfTriangle(int... data) {
		return areaCalculationStrategy.calculateArea(data);
	}
}
