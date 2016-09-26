package com.epam;

import com.epam.strategy.AreaCalculationContext;
import com.epam.strategy.ThreeSidesAreaCalculationStrategy;
import com.epam.strategy.TwoSidesAndAngleStrategy;

public class StrategySample {
	public static void exec() {

		AreaCalculationContext areaCalculationContext = new AreaCalculationContext(new TwoSidesAndAngleStrategy());
		double area1 = areaCalculationContext.calculateAreaOfTriangle(10, 20, 40);

		System.out.println(" area calcuated by 1 stategy " + area1);

		AreaCalculationContext areaCalculationContext2 = new AreaCalculationContext(
				new ThreeSidesAreaCalculationStrategy());
		double area2 = areaCalculationContext2.calculateAreaOfTriangle(10, 20, 40);

		System.out.println(" area calcuated by 2 stategy " + area2);

	}
}
