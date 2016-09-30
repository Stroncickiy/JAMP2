package com.epam.interpreter;

import java.util.ArrayList;
import java.util.List;

public class BooleanExpressionEvaluator {

	public boolean interpretStringAsBoolean(String expression) {
		boolean result = false;
		StringBuilder expressionBuffer = new StringBuilder(expression.trim());
		List<Boolean> operands = new ArrayList<>();
		Operator operator = null;
		int groupNumber = 0;
		StringBuffer bufferCurrentGroup = new StringBuffer();
		while (expressionBuffer.length() > 0) {
			int numberParts = 0;
			for (String expressionPart : expressionBuffer.toString().split("\\s+")) {
				bufferCurrentGroup.append(expressionPart);
				bufferCurrentGroup.append(" ");

				if(expressionPart.equalsIgnoreCase("true")||expressionPart.equalsIgnoreCase("false")){
					operands.add(Boolean.valueOf(expressionPart));
				}else{					
					if(operator == null){						
						operator = Operator.valueOf(expressionPart);
					}else{
						operator = Operator.withInversion(operator);
					}
				}
				numberParts += 1;
				if (isEnoughToComputePartOfExpression(operator, operands)) {
					groupNumber++;
					boolean computingResult = evaluateOperation(operator, operands);
					if(groupNumber==1){						
						System.out.println("evaluation of "+groupNumber+" group  "+bufferCurrentGroup.toString()+" = "+String.valueOf(computingResult).toUpperCase()); 
					}else{
						System.out.println("evaluation of "+groupNumber+" group  "+String.valueOf(operands.get(0)).toUpperCase()+" "+bufferCurrentGroup.toString()+" = "+String.valueOf(computingResult).toUpperCase() ); 
					}
					operands.clear();
					operands.add(computingResult);
					operator = null;
					removePartsFromHeadOfBuffer(expressionBuffer, numberParts);
					bufferCurrentGroup.delete(0, bufferCurrentGroup.length());
					break;
				}
			}

		}
		if(operands.size()>0){
			result = operands.get(0);
		}
		return result;
	}

	private void removePartsFromHeadOfBuffer(StringBuilder expressionBuffer, int numberParts) {
		while (numberParts > 0) {
			if(expressionBuffer.indexOf(" ")>0){				
				expressionBuffer.delete(0, expressionBuffer.indexOf(" ")+1);
			}else{
				expressionBuffer.delete(0, expressionBuffer.length());
			}
			--numberParts;
		}
	}

	private Boolean evaluateOperation(Operator operator, List<Boolean> operands) {
		if (operator.needTwoOperands()) {
			return operator.applyOperatorToOperands(operands.get(0), operands.get(1));
		} else {
			return operator.applyOperatorToOperands(operands.get(0), false);
		}
	}

	private boolean isEnoughToComputePartOfExpression(Operator operator, List<Boolean> operands) {
		if (operator == null) {
			return false;
		}
		if (operator.needTwoOperands()) {
			return operands.size() == 2;
		} else {
			return operands.size() == 1;
		}
	}

}
