/**
 * 
 */
package stack;

import java.util.Stack;

/**
 * @author nagendra
 * 
 * Paranthesis Matching Problem
 *
 */
public class ParanthesisMatching {

	public static void main(String[] args) {
		System.out.println(isMatchin("[()]{}{[()()]()}")); // true
		System.out.println(isMatchin("[(])")); // false
		System.out.println(isMatchin("eeeeee")); // true
	}

	final static char L_S_BRACKET = '(';
	final static char R_S_BRACKET = ')';

	final static char L_M_BRACKET = '{';
	final static char R_M_BRACKET = '}';

	final static char L_L_BRACKET = '[';
	final static char R_L_BRACKET = ']';

	public static boolean isMatchin(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			try {
				if (c == L_S_BRACKET || c == L_M_BRACKET || c == L_L_BRACKET) {
					stack.push(c);
				} else if (c == R_S_BRACKET || c == R_M_BRACKET || c == R_L_BRACKET) {
					if (stack.pop() != matching(c))
						return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	static char matching(char c) {
		switch (c) {
		case R_S_BRACKET:
			return L_S_BRACKET;
		case R_M_BRACKET:
			return L_M_BRACKET;
		default:
			return L_L_BRACKET;
		}
	}

}
