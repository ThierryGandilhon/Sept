package sept.sept;

public enum Operator {
	PLUS("+", true),
	MINUS("-", false),
	TIMES("*", true),
	DIVIDE("/", false);

	private final String  label;
	private final boolean isCommutative;

	Operator(String label, boolean isCommutative) {
		this.label = label;
		this.isCommutative = isCommutative;
	}

	public String toString() {
		return label;
	}

	public boolean isCommutative() {
		return isCommutative;
	}
}
