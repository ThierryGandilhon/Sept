package sept.sept;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEquals {

	@Test
	public void testNullOperand() {
		Expression one = new Operand(1);
		assertFalse(one.equals((Expression) null));
	}

	@Test
	public void testEqualOperands() {
		Expression one = new Operand(1);
		assertTrue(one.equals(one));
	}

	@Test
	public void testDifferentOperands() {
		Expression one = new Operand(1);
		Expression two = new Operand(2);
		assertFalse(one.equals(two));
	}

	@Test
	public void testDifferentOperatorAndOperand() {
		Expression one = new Operand(1);
		Expression plus = new Operation(Operator.PLUS, new Operand(2), new Operand(3));
		assertFalse(one.equals(plus));
	}

	
	
	@Test
	public void testNullOperation() {
		Expression plus = new Operation(Operator.PLUS, new Operand(1), new Operand(2));
		assertFalse(plus.equals((Expression) null));
	}

	@Test
	public void testEqualOperations() {
		Expression a = new Operation(Operator.PLUS, new Operand(1), new Operand(2));
		assertTrue(a.equals(a));
	}

	@Test
	public void testDifferentOperations1() {
		Expression a = new Operation(Operator.PLUS, new Operand(1), new Operand(2));
		Expression b = new Operation(Operator.MINUS, new Operand(1), new Operand(2));
		assertFalse(a.equals(b));
	}

	@Test
	public void testDifferentOperations2() {
		Expression a = new Operation(Operator.PLUS, new Operand(1), new Operand(2));
		Expression b = new Operation(Operator.PLUS, new Operand(1), new Operand(3));
		assertFalse(a.equals(b));
	}

	@Test
	public void testDifferentOperandAndOperator() {
		Expression one = new Operand(1);
		Expression plus = new Operation(Operator.PLUS, new Operand(2), new Operand(3));
		assertFalse(plus.equals(one));
	}

	@Test
	public void testEqualOperationsTwoLevels() {
		Expression a = new Operation(Operator.PLUS, 
                new Operation(Operator.PLUS, new Operand(1), new Operand(2)),
                new Operation(Operator.MINUS, new Operand(3), new Operand(4)));
		Expression b = new Operation(Operator.PLUS, 
                new Operation(Operator.PLUS, new Operand(1), new Operand(2)),
                new Operation(Operator.MINUS, new Operand(3), new Operand(4)));
		assertTrue(a.equals(b));
	}
	
	@Test
	public void testDifferentOperationsTwoLevels() {
		Expression a = new Operation(Operator.PLUS, 
                new Operation(Operator.PLUS, new Operand(1), new Operand(2)),
                new Operation(Operator.MINUS, new Operand(3), new Operand(4)));
		Expression b = new Operation(Operator.PLUS, 
                new Operation(Operator.PLUS, new Operand(1), new Operand(2)),
                new Operation(Operator.MINUS, new Operand(3), new Operand(5)));
		assertFalse(a.equals(b));
	}	
}
