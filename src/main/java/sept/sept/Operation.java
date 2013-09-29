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
	
	
	public boolean equals(Expression expression) {
		return     expression.isOperand() 
				&& ((Operation) expression).left.equals(this.left) 
				&& ((Operation) expression).right.equals(this.right);
	}
	
	


	public List<Expression> combine(Expression expression) {
		List<Expression> leftCombinations = left.combine(expression);
		List<Expression> rightCombinations = right.combine(expression);

		List<Expression> allCombinations = new LinkedList<Expression>();

		for ( Expression leftExpression:leftCombinations ) {
			if ( operator == Operator.DIVIDE && right.eval().equals(0) )
				continue;
			
			allCombinations.add(new Operation(operator, leftExpression, right));
		}

		if ( !operator.isCommutative() ) {
			for ( Expression rightExpression:rightCombinations ) {
				if ( operator == Operator.DIVIDE && rightExpression.eval().equals(0) )
					continue;
				
				allCombinations.add(new Operation(operator, left, rightExpression));
			}
		}
		return allCombinations;
	}
}
