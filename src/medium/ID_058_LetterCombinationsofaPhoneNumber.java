package medium;

import java.util.ArrayList;
import java.util.List;

public class ID_058_LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		ID_058_LetterCombinationsofaPhoneNumber problem = new ID_058_LetterCombinationsofaPhoneNumber();

		System.out.println("23 = " + problem.new Solution().letterCombinations("23"));

	}

	class Solution {
		public List<String> letterCombinations(String digits) {
			List<String> combos = new ArrayList<String> ();
			String[] map = new String[]{
					"",			// 0
					"",			// 1
					"abc",		// 2
					"def",		// 3
					"ghi",		// 4
					"jkl",		// 5
					"mno",		// 6
					"pqrs",		// 7
					"tuv",		// 8
					"wxyz"		// 9					
			};
			//			String[] combo = new String[]{""};
			String combo = "";
			if(digits == "" || digits == null || digits.length() == 0) {

			}
			else {
				bt(digits, combos, combo, map);
			}
			return combos;
		}

		private void bt(String digits, List<String> combos, String combo, String[] map) {
			if (reject(digits, combos, combo, map)) {
				// terminate if a combo is found
				combos.add(new String(combo).trim());
				combo = new String(combo.substring(0, combo.length() - 1));
				return;
			}
			if (accept(digits, combos, combo, map)) {
				output(digits, combos, combo, map);
			}
			//s <- first(problem)
			int i = 0;
			while(i < map[digits.charAt(combo.length()) - '0'].length()) {
				String new_combo = new String(combo + map[digits.charAt(combo.length()) - '0'].toCharArray()[i]);
				bt(digits, combos, new_combo, map);
				i ++;
			}
		}

		private boolean reject(String digits, List<String> combos, String combo, String[] map) {
			return combo.length() == digits.length();
		}

		private boolean accept(String digits, List<String> combos, String combo, String[] map) {
			return combo.length() < digits.length();
		}

		private void output(String digits, List<String> combos, String combo, String[] map) {
			// do nothing
		}
	}
}
