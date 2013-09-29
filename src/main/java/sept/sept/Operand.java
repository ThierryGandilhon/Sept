package sept.sept;

import java.util.LinkedList;
import java.util.List;

public class Operand extends Expression {
	public final Integer value;
	
	public Operand(Integer value) {
		this.value = value;
	}

	public boolean isOperand() {
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
	public Expression eval() {
		return this;
	}
	
	public boolean equals(Expression expression) {
		return expression.isOperand() && ((Operand) expression).value == this.value;
	}
	
	public List<Expression> combine(Operator operator, Expression expression) {
		List<Expression> combinations = new LinkedList<Expression>();
		combinations.add(new Operation(operator, this, expression));
		return combinations;
	}

	public List<Expression> combine(Expression expression) {
		List<Expression> combinations = new LinkedList<Expression>();
		combinations.add(new Operation(Operator.PLUS, this, expression));
		combinations.add(new Operation(Operator.MINUS, this, expression));
		combinations.add(new Operation(Operator.TIMES, this, expression));
		if ( expression != null && !expression.eval().equals(0) ) {
			combinations.add(new Operation(Operator.DIVIDE, this, expression));			
		}
		return combinations;
	}

}
 