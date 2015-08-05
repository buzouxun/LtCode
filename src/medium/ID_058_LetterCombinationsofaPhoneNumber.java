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
					" ",		// 0
					" ",		// 1
					"abc",		// 2
					"def",		// 3
					"ghi",		// 4
					"jkl",		// 5
					"mno",		// 6
					"pqrs",		// 7
					"tuv",		// 8
					"wxyz"		// 9					
			};
			String[] combo = new String[]{""};
			bt(digits, combos, combo, map);
			return combos;
		}

		private void bt(String digits, List<String> combos, String[] combo, String[] map) {
			if (reject(digits, combos, combo, map)) {
				// TODO
				return;
			}
			if (accept(digits, combos, combo, map)) {
				output(digits, combos, combo, map);
				//				System.out.println("comboooo = " + combo[0]);
			}
			//s <- first(problem)
			int i = 0;
			while(i < map[digits.charAt(combo[0].length()) - '0'].length()) {
				combo[0] = combo[0] + map[digits.charAt(combo[0].length()) - '0'].toCharArray()[i];
				bt(digits, combos, combo, map);
				//s <- next(problem)
				i ++;
			}
		}

		private boolean reject(String digits, List<String> combos, String[] combo, String[] map) {
			return combo[0].length() == digits.length();
		}

		private boolean accept(String digits, List<String> combos, String[] combo, String[] map) {
			return combo[0].length() > digits.length();
		}

		private void output(String digits, List<String> combos, String[] combo, String[] map) {
//			combos.add(new String(combo[0]).trim());
//			System.out.println("combo = " + combo[0]);
//			combo[0] = "";
		}
	}
}
