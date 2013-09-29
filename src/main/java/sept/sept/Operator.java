package sept.sept;

public enum Operator {
	PLUS {
		public String toString() {
			return "+";
		}

		public boolean isCommutative() {
			return true;
		}
	},
	MINUS {
		public String toString() {
			return "-";
		}

		public boolean isCommutative() {
			return false;
		}
	},
	TIMES {
		public String toString() {
			return "*";
		}

		public boolean isCommutative() {
			return true;
		}
	},
	DIVIDE {
		public String toString() {
			return "/";
		}

		public boolean isCommutative() {
			return false;
		}
	}
}
