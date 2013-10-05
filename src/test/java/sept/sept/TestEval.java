package sept.sept;

import static org.junit.Assert.*;

import org.junit.Test;

import sept.sept.Expression;
import sept.sept.Operand;
import sept.sept.Operation;
import sept.sept.Operator;


public class TestEval {

	@Test
	public void testPlusSucess() {
		Expression exp = new Operation(Operator.PLUS, new Operand(1), new Operand(1));
		assertTrue(exp.eval().equals(2));
	}

	@Test
	public void testPlusFailure() {
		Expression exp = new Operation(Operator.PLUS, new Operand(1), new Operand(1));
		assertFalse(exp.eval().equals(1));
	}

	@Test
	public void tesMinusSucess() {
		Expression exp = new Operation(Operator.MINUS, new Operand(1), new Operand(1));
		assertTrue(exp.eval().equals(0));
	}

	@Test
	public void testMinusFailure() {
		Expression exp = new Operation(Operator.MINUS, new Operand(1), new Operand(1));
		assertFalse(exp.eval().equals(1));
	}

	@Test
	public void testTimesSucess() {
		Expression exp = new Operation(Operator.TIMES, new Operand(2), new Operand(2));
		assertTrue(exp.eval().equals(4));
	}

	@Test
	public void testTimesFailure() {
		Expression exp = new Operation(Operator.TIMES, new Operand(2), new Operand(2));
		assertFalse(exp.eval().equals(2));
	}
	
	@Test
	public void testDivideSucess() {
		Expression exp = new Operation(Operator.DIVIDE, new Operand(2), new Operand(2));
		assertTrue(exp.eval().equals(1));
	}
	
	@Test
	public void testDivideFailure() {
		Expression exp = new Operation(Operator.DIVIDE, new Operand(2), new Operand(2));
		assertFalse(exp.eval().equals(2));
	}
}
