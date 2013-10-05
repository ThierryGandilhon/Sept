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
	

	@Override
	public boolean equals(Object object) {
		if ( object == null) 			        return false;		
		if ( object == this )                   return true;
		if ( !(object instanceof Operand) )	return false;
		
		Operand operand = (Operand) object;
		return (operand.value == this.value);
	}


	/*
	 * Combine an operand (this) and an expression. To do so, generates
	 * the for arithmetic operations combining the operand (this) and the 
	 * expression passed as a parameter.
	 * 
	 * Note that we do not generate the divide operation if the expression
	 * evals to zero.
	 * 
	 * @see sept.sept.Expression#combine(sept.sept.Expression)
	 */
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
 