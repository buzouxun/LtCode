package medium;

import java.util.*;

public class ID_098_RestoreIPAddresses {

	public static void main(String[] args) {
		ID_098_RestoreIPAddresses problem = new ID_098_RestoreIPAddresses();
				System.out.println(problem.new Solution().restoreIpAddresses("25525511135"));
		System.out.println(problem.new Solution().restoreIpAddresses("010010"));
		System.out.println(problem.new Solution().restoreIpAddresses("103574606193"));
		//		System.out.println("25.525.".split("\\.")[0]);
	}

	class Solution {

		// 25525511135 -> ["255.255.11.135", "255.255.111.35"]

		public List<String> restoreIpAddresses(String s) {
			List<String> res = new ArrayList<String> ();
//			if(12 == s.length()) {
//				res.add(new String(s.substring(0, 3) + "." + s.substring(3, 6) + "." + s.substring(6, 9) + "." + s.substring(9, 12)));
//			}
//			else 
			if(4 == s.length()) {
				res.add(new String(s.substring(0, 1) + "." + s.substring(1, 2) + "." + s.substring(2, 3) + "." + s.substring(3, 4)));
			}
			else if(s.length() > 12) {
				// do nothing
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
			if(numDots < 0 || numDots > 4) {
				return;
			}
			if(numDots > 0 && numDots <= 4) {
				// start with 0
				if(guess.split("\\.")[numDots - 1].startsWith("0") && guess.split("\\.")[numDots - 1].length() > 1) {
					return;
				}				
				// number [0, 255]
				int num = Integer.valueOf(guess.split("\\.")[numDots - 1]);
				if(num < 0 || num > 255) {
					return;
				}
			}
			// accept
			if(numDots == 4) {
				res.add(guess.substring(0, guess.length() - 1));
			}

			// DEBUG
			//			if(guess.equals("0.10.0.")) {
			//
			//			}

			// first
			int i = initialSize;
			while(i <= 3 && i >= 1) {
				if(choices.length() >= i) {
					String new_guess = new String(guess);
					int new_numDots = numDots;
					if(numDots >= 0 && numDots <= 2) {
						new_guess += choices.substring(0, i) + ".";
					}
					if(numDots == 3) {
						new_guess += choices + ".";
					}
					new_numDots ++;
					String new_choices = choices.substring(0 + i, choices.length());
					helper(new_choices, new_guess, res, initialSize, new_numDots);
				}
				if(numDots == 3) {
					i = Integer.MAX_VALUE;
				}
				else {
					i++;
				}
			}
		}

	}

}
