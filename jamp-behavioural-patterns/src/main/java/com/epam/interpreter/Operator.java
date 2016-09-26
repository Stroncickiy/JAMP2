package com.epam.interpreter;

public enum Operator {
	AND {
		@Override
		public boolean applyOperatorToOperands(boolean... operands) {
			return operands[0] && operands[1];
		}
	},
	OR {
		@Override
		public boolean applyOperatorToOperands(boolean... operands) {
			return operands[0] || operands[1];
		}
	};

	public abstract boolean applyOperatorToOperands(boolean... operands);
}
