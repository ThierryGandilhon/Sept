package sept.sept;

import java.util.LinkedList;
import java.util.List;

public class Sept {
	public static void main (String[] args) {

		int theNumber = 7;

		// Step 1
		List<Expression> initialList = new LinkedList<Expression>();
		initialList.add(new Operand(theNumber));
		showCombinations("Combinations of 1", initialList);		
		

		List<Expression> currentList = initialList;

		for (int i = 2 ; i <= theNumber ; i++) {
			List<Expression> newList = new LinkedList<Expression>();
			newList = createCombinations(initialList, currentList);
			showCombinations("Combinations of " + i , newList);		
			currentList = newList;
		}
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
		

	
	private static void showCombinations(String label, List<Expression> expressions) {
		System.out.println(label + ": " + expressions.size()+ " found.");
		
		// int i = 0;
		// for ( Expression expression : expressions ) {
		// 	System.out.println(label + " (" + ++i + "):" + expression.toString() + " = " + expression.eval());
		// }

	}
}
