package easy;

import java.util.Stack;

public class ID_08_ValidParentheses {

	public static void main(String[] args) {
		ID_08_ValidParentheses problem = new ID_08_ValidParentheses();
		boolean test;
		
		// "()[]{}" -> true
		test = problem.new Solution().isValid("()[]{}");
		System.out.print("'()[]{}'' -> " + test);

	}

	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not. 
	 */

	class Solution {
		public boolean isValid(String s) {
			boolean valid = true;			
			Stack<Character> parentheseStack = new Stack<Character>();
			for(char c : s.toCharArray()) {
				if("([{".indexOf(c) != -1) {
					parentheseStack.push(c);
				}
				else if (")]}".indexOf(c) != -1) {
					if(parentheseStack.isEmpty() || !matchTwoParethences((char) parentheseStack.peek(), c)) {
						valid = false;
						break;
					}
					else {
						parentheseStack.pop();
					}
				}
			}
			
			if(!parentheseStack.isEmpty()) {
				valid = false;
			}
			
			return valid;
		}
		
		private boolean matchTwoParethences(char p1, char p2) {
			return (p1 == '(' && p2 == ')') || (p1 == '{' && p2 == '}') || (p1 == '[' && p2 == ']');
		}
	}

}
