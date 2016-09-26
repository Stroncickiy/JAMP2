package com.epam.interpreter;

public class BooleanExpressionEvaluator {

	public boolean interpretStringAsBoolean(String expression) {
		boolean result = false;
		boolean accumulator = false;
		Operator operator = null;
		boolean firstBooleanValueAssigned = false;
		boolean shouldInvert = false;

		for (String expressionPart : expression.split("\\s+")) {
			if (expressionPart.equalsIgnoreCase("not")) {
				shouldInvert = true;
			} else {
				if ((expressionPart.equalsIgnoreCase("and")) || (expressionPart.equalsIgnoreCase("or"))) {
					operator = Operator.valueOf(expressionPart);
				} else if (expressionPart.equalsIgnoreCase("true")) {
					if (!firstBooleanValueAssigned) {
						result = evaluateExpressionWithPreOperands(true, shouldInvert);
						firstBooleanValueAssigned = true;
					} else {
						accumulator = evaluateExpressionWithPreOperands(true, shouldInvert);
						result = operator.applyOperatorToOperands(result, accumulator);
					}
				} else if (expressionPart.equalsIgnoreCase("false")) {
					if (!firstBooleanValueAssigned) {
						result = evaluateExpressionWithPreOperands(false, shouldInvert);
						firstBooleanValueAssigned = true;
					} else {
						accumulator = evaluateExpressionWithPreOperands(false, shouldInvert);
						result = operator.applyOperatorToOperands(result, accumulator);
					}
				}
				shouldInvert = false;
			}

		}

		return result;
	}

	private boolean evaluateExpressionWithPreOperands(boolean b, boolean shouldInverNext) {
		if (shouldInverNext) {
			return !b;
		} else {
			return b;
		}
	}
}
