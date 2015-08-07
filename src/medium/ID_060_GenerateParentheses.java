package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ID_060_GenerateParentheses {

	public static void main(String[] args) {
		ID_060_GenerateParentheses problem = new ID_060_GenerateParentheses();

//		System.out.println("1 = " + problem.new Solution().generateParenthesis(1));		
		System.out.println("2 = " + problem.new Solution().generateParenthesis(3));	

	}

	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> res = new ArrayList<String>();
			String s  = new String("");
			bt(res, 2 * n, s);
			return res;
		}

		private void bt(List<String> res, int n, String s) {
			if(reject(res, n, s)) {
				return;
			}
			if(accept(res, n, s)) {
				res.add(s);
				return;
			}
			n = n - 1;
			String[] choices = new String[]{"(", ")"};
			int i = 0;
			while(i < choices.length) {
				String choice = choices[i];
				String new_s = s + choice;
				bt(res, n, new_s);
				i ++;
			}
		}

		private boolean accept(List<String> res, int n, String s) {
			return n == 0 && !isNotWellFormed(s, n);
		}

		private boolean reject(List<String> res, int n, String s) {
			boolean rej = false;
			if(n < 0) {
				rej = true;
			}
			if(isNotWellFormed(s, n)) {
				rej = true;
			}
			return rej;
		}

		private boolean isNotWellFormed(String s, int n) {
			boolean notWellFormed = false;
			Stack<Character> stack = new Stack<Character>();
			char[] parentheses = s.toCharArray();
			for(int i = 0; i < parentheses.length; i++) {
				char p = parentheses[i];
				if(p == '(') {
					stack.push(p);
				}
				else if (p == ')') {
					if(stack.isEmpty()) {
						notWellFormed = true;
					}
					else{
						stack.pop();
					}
				}
				else {
					notWellFormed = true;
				}
			}
			if(!stack.isEmpty() && n == 0) {
				notWellFormed = true;
			}
			return notWellFormed;
		}
	}

}
