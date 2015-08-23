package medium;

import java.util.*;

public class ID_098_RestoreIPAddresses {

	public static void main(String[] args) {
		ID_098_RestoreIPAddresses problem = new ID_098_RestoreIPAddresses();
//		System.out.println(problem.new Solution().restoreIpAddresses("25525511135"));
		System.out.println(problem.new Solution().restoreIpAddresses("010010"));
//		System.out.println("25.525.".split("\\.")[0]);
	}

	class Solution {

		// 25525511135 -> ["255.255.11.135", "255.255.111.35"]

		public List<String> restoreIpAddresses(String s) {
			List<String> res = new ArrayList<String> ();
			if(12 == s.length()) {
				res.add(new String(s.substring(0, 3) + "." + s.substring(3, 6) + "." + s.substring(6, 9) + "." + s.substring(9, 12)));
			}
			else if(4 == s.length()) {
				res.add(new String(s.substring(0, 1) + "." + s.substring(1, 2) + "." + s.substring(2, 3) + "." + s.substring(3, 4)));
			}
			else {
				int initialSize = 1;
				if(s.length() > 10) {
					initialSize = 2;
				}
				String guess = "";
				int numDots = 0;
				helper(s, guess, res, initialSize, numDots);
			}	        
			return res;
		}

		private void helper(String choices, String guess, List<String> res, int initialSize, int numDots) {
			// reject
			
			// accept
			
			int i = initialSize;
			while(i <= 3 && i >= 1) {
				if(choices.length() >= i) {
					String new_guess = new String(guess);
					int new_numDots = numDots;
					
					
					String new_choices = choices.substring(0 + i, choices.length());
					helper(new_choices, new_guess, res, initialSize, new_numDots);
				}
				i++;
			}
		}
		
	}

}
