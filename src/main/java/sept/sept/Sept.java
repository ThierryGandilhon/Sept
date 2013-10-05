package sept.sept;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.TreeMultimap;
import com.google.common.collect.Multimap;

public class Sept {
	public static void main (String[] args) {

		int theNumber = 7;

		// Step 1: generate all forms.
		List<Expression> initialList = new LinkedList<Expression>();
		initialList.add(new Operand(theNumber));
		//showCombinations("Combinations of 1", initialList);		
		

		List<Expression> currentList = initialList;

		for (int i = 2 ; i <= theNumber ; i++) {
			List<Expression> newList = new LinkedList<Expression>();
			newList = createCombinations(initialList, currentList);
			//showCombinations("Combinations of " + i , newList);		
			currentList = newList;
		}

		countCombinations(currentList);
	}
	
	
	private static List<Expression> createCombinations(List<Expression> expressions, List<Expression> templates) {
		List<Expression> combinations = new LinkedList<Expression>();
		
		for ( Expression expression : expressions ) {
			for ( Expression template : templates ) {
				List<Expression> results = template.combine(expression); 
				for (Expression e : results) {
					combinations.add(e);
				}
			}
		}	
		
		return combinations;
	}
		

	
	static void showCombinations(String label, List<Expression> expressions) {
		System.out.println(label + ": " + expressions.size()+ " found.");
		
		int i = 0;
		for ( Expression expression : expressions ) {
			System.out.println(label + " (" + ++i + "):" + expression.toString() + " = " + expression.eval());
		}

	}


	private static void countCombinations(List<Expression> expressions) {
		TreeMultimap<Integer, Expression> countCombinations = TreeMultimap.create();
		
		for ( Expression expression : expressions ) {
			try {
				Expression value = expression.eval();
				countCombinations.put(Integer.parseInt(value.toString()), expression);
			}
			catch ( ArithmeticException e ) {
				// Nothing
			}
		}
		
		for ( Integer key : countCombinations.keySet() ) {
			int count = countCombinations.get(key).size();
			
			System.out.println("Sum = " + key + " : " + count + " solutions.");
		}
	}
}


