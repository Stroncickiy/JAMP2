package com.epam;

import com.epam.interpreter.BooleanExpressionEvaluator;

public class InterpreterSample {
	private static final String EXPRESSION_1 = "TRUE OR FALSE AND TRUE";
	private static final String EXPRESSION_2 = "NOT FALSE AND NOT TRUE";
	
	public static void exec() {
		BooleanExpressionEvaluator booleanExpressionEvaluator = new BooleanExpressionEvaluator();
		System.out.println("expression: " + EXPRESSION_1);
		boolean expression1Result = booleanExpressionEvaluator.interpretStringAsBoolean(EXPRESSION_1);
		System.out.println(" given us result " + expression1Result);
		
		System.out.println("expression: " + EXPRESSION_2);
		boolean expression2Result = booleanExpressionEvaluator.interpretStringAsBoolean(EXPRESSION_2);
		System.out.println(" given us result " + expression2Result);
		
	}
}
