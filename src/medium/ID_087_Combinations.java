package medium;

import java.util.*;

public class ID_087_Combinations {

	public static void main(String[] args) {
		ID_087_Combinations problem = new ID_087_Combinations();
		System.out.println(problem.new Solution().combine(4, 2));
	}

	class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			if(n < 1 || k < 1 || k > n) {
				// do nothing
			}
			else {
				List<Integer> combo = new ArrayList<Integer>();
				int[] choices = new int[n];
				for(int i = 1; i <= n; i++) {
					choices[i - 1] = i;
				}
				bt(res, choices, k, combo);
			}			
			return res;
		}

		private void bt(List<List<Integer>> res, int[] choices, int k, List<Integer> combo) {
			if(combo.size() == k) {
				res.add(combo);
				return;
			}
			int i = 0;
			while(i < choices.length) {
				int[] new_choices = Arrays.copyOfRange(choices, i + 1, choices.length);
				List<Integer> new_combo = new ArrayList<Integer>(combo);
				new_combo.add(choices[i]);
				bt(res, new_choices, k, new_combo);
				i ++;
			}			
		}
	}
}
