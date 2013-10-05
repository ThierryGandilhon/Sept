package sept.sept;

import java.util.LinkedList;
import java.util.List;

public class Operation extends Expression {
	public final Operator   operator;
	public final Expression left;
	public final Expression right;
	
	public Operation(Operator operator, Expression left, Expression right) {
		this.operator = operator;
		this.left    = left;
		this.right   = right;
	}
	
	@Override
	public String toString() {
		return "(" + left.toString() + " " + operator.toString() + " " + right.toString() + ")";
	}

	public Expression eval() {
		Expression leftEval = left.eval();
		Expression rightEval = right.eval();
		
		switch (operator) {
		case PLUS:
			return new Operand(((Operand) leftEval).value + ((Operand) rightEval).value);
			
		case MINUS:
			return new Operand(((Operand) leftEval).value - ((Operand) rightEval).value);
			
		case TIMES:
			return new Operand(((Operand) leftEval).value * ((Operand) rightEval).value);
			
		case DIVIDE:
			return new Operand(((Operand) leftEval).value / ((Operand) rightEval).value);
			
		default:
			return new Operand(-99999);
		}
	}
	

	@Override
	public boolean equals(Object object) {
		if ( object == null) 			        return false;		
		if ( object == this )                   return true;
		if ( !(object instanceof Operation) )	return false;
		
		Operation expression = (Operation) object;
		return     expression.operator == this.operator 
				&& expression.left.equals(this.left) 
				&& expression.right.equals(this.right);
	}
	
	


	/*
	 * Combine two expressions. To do so, we 
	 * 
	 * @see sept.sept.Expression#combine(sept.sept.Expression)
	 */
	public List<Expression> combine(Expression expression) {
		List<Expression> allCombinations = new LinkedList<Expression>();

		List<Expression> leftCombinations = left.combine(expression);
		for ( Expression leftExpression:leftCombinations ) {
			if ( operator == Operator.DIVIDE && right.eval().equals(0) )
				continue;
			
			allCombinations.add(new Operation(operator, leftExpression, right));
		}

		List<Expression> rightCombinations = right.combine(expression);
		for ( Expression rightExpression:rightCombinations ) {
			if ( operator == Operator.DIVIDE && rightExpression.eval().equals(0) )
				continue;
			
			allCombinations.add(new Operation(operator, left, rightExpression));
		}

		return allCombinations;
	}
}
