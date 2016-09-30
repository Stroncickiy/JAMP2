package com.epam;

import com.epam.strategy.AreaCalculationContext;
import com.epam.strategy.ThreeSidesAreaCalculationStrategy;
import com.epam.strategy.Triangle;
import com.epam.strategy.TwoSidesAndRightAngleStrategy;

public class StrategySample {
	public static void exec() {

		AreaCalculationContext areaCalculationContext = new AreaCalculationContext(new TwoSidesAndRightAngleStrategy());
		Triangle trinagle = new Triangle(12, 16, 20);
		double area1 = areaCalculationContext.calculateAreaOfTriangle(trinagle);

		System.out.println(" area calcuated by 1 stategy " + area1);

		AreaCalculationContext areaCalculationContext2 = new AreaCalculationContext(
				new ThreeSidesAreaCalculationStrategy());
		Triangle triangle2 = new Triangle(12, 16, 20);
		double area2 = areaCalculationContext2.calculateAreaOfTriangle(triangle2);

		System.out.println(" area calcuated by 2 stategy " + area2);

	}
}
