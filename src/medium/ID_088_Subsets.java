package medium;

import java.util.*;

public class ID_088_Subsets {

	public static void main(String[] args) {
		ID_088_Subsets problem = new ID_088_Subsets();
		System.out.println(problem.new Solution().subsets(new int[]{1, 2, 3}));
	}
	
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	List<Integer> combo = new ArrayList<Integer>();
	    	Arrays.sort(nums);
	    	bt(nums, res, combo, nums.length);
	    	return res;
	    }

		private void bt(int[] choices, List<List<Integer>> res, List<Integer> combo, int maxLength) {
			if(combo.size() <= maxLength) {
				res.add(combo);
			}
			int i = 0;
			while(i < choices.length) {
				List<Integer> newCombo = new ArrayList<Integer>(combo);
				newCombo.add(choices[i]);
				int[] new_choices = Arrays.copyOfRange(choices, i + 1, choices.length);
				bt(new_choices, res, newCombo, maxLength);
				i ++;
			}			
		}
	}
}
