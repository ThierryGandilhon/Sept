package sept.sept;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import sept.sept.Operator;

public class TestCombine {

	@Test
	public void testCombineTwoOperands() {
		Expression left = new Operand(1);
		Expression right = new Operand(2);
		
		List<Expression> expressions = left.combine(right);

		assertTrue(expressions.size() == 4);
		assertTrue(expressions.contains(new Operation(Operator.PLUS, new Operand(1), new Operand(2))));
		assertTrue(expressions.contains(new Operation(Operator.MINUS, new Operand(1), new Operand(2))));
		assertTrue(expressions.contains(new Operation(Operator.DIVIDE, new Operand(1), new Operand(2))));
		assertTrue(expressions.contains(new Operation(Operator.TIMES, new Operand(1), new Operand(2))));
	}

	@Test
	public void testCombineTwoOperandsDivideByZero() {
		Expression left = new Operand(1);
		Expression right = new Operand(0);
		
		List<Expression> expressions = left.combine(right);

		assertTrue(expressions.size() == 3);
		assertTrue(expressions.contains(new Operation(Operator.PLUS, new Operand(1), new Operand(0))));
		assertTrue(expressions.contains(new Operation(Operator.MINUS, new Operand(1), new Operand(0))));
		assertFalse(expressions.contains(new Operation(Operator.DIVIDE, new Operand(1), new Operand(0))));
		assertTrue(expressions.contains(new Operation(Operator.TIMES, new Operand(1), new Operand(0))));
	}

	@Test
	public void testCombineOperandAndOperation() {
		Expression left = new Operand(3);
		Expression right  = new Operation(Operator.PLUS, new Operand(1), new Operand(2));
		
		List<Expression> expressions = right.combine(left);
		assertTrue(expressions.size() == 8);
	}
}
