package sept.sept;

import java.util.LinkedList;
import java.util.List;

public abstract class Expression {
	public abstract String toString();
	public abstract Expression eval();
	public abstract boolean equals(Expression expression);
	public boolean equals(Integer i) {
		return this.equals(new Operand(i));
	}
	
	public boolean isOperand() {
		return false;
	}
	
	public abstract List<Expression> combine(Expression expression);

}
