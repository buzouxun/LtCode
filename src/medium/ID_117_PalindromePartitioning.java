package medium;

import java.util.*;

public class ID_117_PalindromePartitioning {

	public static void main(String[] args) {
		ID_117_PalindromePartitioning problem = new ID_117_PalindromePartitioning();
		
		
		System.out.println(problem.new Solution().partition("aab"));
	}

	class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> res = new ArrayList<List<String>>();
			List<String> guess = new ArrayList<String>();
			helper(res, guess, s);
			
			return res;		
		}

		private void helper(List<List<String>> res, List<String> guess, String candidates) {
			// terminate
			if(guess.size() > 0 && !isPalindrome(guess.get(guess.size() - 1))) {
				return;
			}
			// accept
			if(candidates.length() == 0 && guess.size() > 0 && isPalindrome(guess.get(guess.size()-1)) ) {
				res.add(guess);
			}			
			// new
			for(int i = 0; i < candidates.length(); i++) {
				String newPal = candidates.substring(0, i + 1);
				String newCandidates = candidates.substring(i + 1, candidates.length());
				List<String> newGuess = new ArrayList<String>(guess);
				newGuess.add(newPal);
				helper(res, newGuess, newCandidates);
			}			
		}
		
		private boolean isPalindrome(String s) {
			boolean pal = true;
			if(s == null || s.length() == 0) {
				pal = false;
			}
			else if(s.length() == 1) {
				// true
			}
			else {
				int leftIdx = 0;
				int rightIdx = s.length() - 1;
				while(leftIdx < rightIdx) {
					if(s.charAt(leftIdx) == s.charAt(rightIdx)){
						leftIdx ++;
						rightIdx --;
					}
					else {
						pal = false;
						break;
					}
				}				
			}
			return pal;
		}
		
	}

}
