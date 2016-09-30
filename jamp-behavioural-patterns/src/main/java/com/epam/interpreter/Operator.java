package com.epam.interpreter;

public enum Operator {
	AND {
		@Override
		public boolean applyOperatorToOperands(boolean operand1, boolean operand2) {
			return operand1 && operand2;
		}

		@Override
		public boolean needTwoOperands() {
			return true;
		}
	},
	OR {
		@Override
		public boolean applyOperatorToOperands(boolean operand1, boolean operand2) {
			return operand1 || operand2;
		}

		@Override
		public boolean needTwoOperands() {
			return true;
		}
	},
	NOT {
		@Override
		public boolean applyOperatorToOperands(boolean operand1, boolean operand2) {
			return !operand1;
		}

		@Override
		public boolean needTwoOperands() {
			return false;
		}
	},
	AND_NOT {
		@Override
		public boolean applyOperatorToOperands(boolean operand1, boolean operand2) {
			return operand1 && !operand2;
		}

		@Override
		public boolean needTwoOperands() {
			return true;
		}
	},
	OR_NOT {
		@Override
		public boolean applyOperatorToOperands(boolean operand1, boolean operand2) {
			return operand1 || !operand2;
		}

		@Override
		public boolean needTwoOperands() {
			return true;
		}
	};

	public abstract boolean applyOperatorToOperands(boolean operand1, boolean operand2);

	public abstract boolean needTwoOperands();

	public static Operator withInversion(Operator operator) {
		if (operator.equals(AND)) {
			return AND_NOT;
		} else {
			return OR_NOT;
		}
	}

}
