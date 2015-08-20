package medium;

import java.util.*;

public class ID_095_SubsetsII {

	public static void main(String[] args) {
		ID_095_SubsetsII problem = new ID_095_SubsetsII();
		System.out.println(problem.new Solution().subsetsWithDup(new int[]{1, 2, 2}));
	}

	class Solution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			List<List<Integer>> res = new ArrayList<List<Integer>> ();
			//			if(num) {
			//
			//			}
			//			else {
			Arrays.sort(nums);
			List<Integer> num = new ArrayList<Integer>();
			helper(nums, num, res, nums.length);
			//			}
			return res;
		}

		private void helper(int[] choices, List<Integer> subset, List<List<Integer>> res, int maxLength) {
			// reject
			// accept
			if(subset.size() <= maxLength) {
				res.add(subset);
			}
			int i = 0;
			while(i < choices.length) {
				if(i > 0 && choices[i] == choices[i - 1]) {
					// duplicates ignored
				}
				else {
					List<Integer> new_subset = new ArrayList<Integer>(subset);
					new_subset.add(choices[i]);
					int[] new_choices = Arrays.copyOfRange(choices.clone(), i + 1, choices.length);
					helper(new_choices, new_subset, res, maxLength);
				}
				i ++;
			}			
		}
	}

}
