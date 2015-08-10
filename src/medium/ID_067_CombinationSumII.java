package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ID_067_CombinationSumII {

	public static void main(String[] args) {
		ID_067_CombinationSumII problem = new ID_067_CombinationSumII();

		// [10,1,2,7,6,1,5], 8
//		System.out.println("[10,1,2,7,6,1,5], 8 -> " + problem.new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
		// [3,1,3,5,1,1], 8
		System.out.println("[3,1,3,5,1,1], 8 -> " + problem.new Solution().combinationSum2(new int[]{3,1,3,5,1,1}, 8));

	}

	class Solution {
		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			List<List<Integer>> res = new ArrayList<List<Integer>> ();
			List<Integer> combo = new LinkedList<Integer> ();
			Arrays.sort(candidates);
			int lastDigitIndex = -1;
			bt(candidates, target, res, combo, lastDigitIndex);
			return res;
		}

		private void bt(int[] candidates, int target, List<List<Integer>> res, List<Integer> combo, int lastDigitIndex) {
			if(reject(target, combo)) {
				return;
			}
			if(accept(target, combo)) {
				res.add(combo);
				return;
			}
			// first
			int[] choices = candidates;
			int i = 0;
			if(lastDigitIndex != -1) {
				i = lastDigitIndex + 1;
			}
			while(i < choices.length) {
				if(i > lastDigitIndex + 1 && candidates[i] == candidates[i - 1]) {
					// do nothing
				}
				else {
					List<Integer> newCombo = new LinkedList<Integer>(combo);
					newCombo.add(choices[i]);
					bt(candidates, target, res, newCombo, i);
				}
				// next
				i ++;
			}
		}

		private boolean reject(int target, List<Integer> combo) {
			boolean reject = false;
			int sum = getSum(combo);
			if(sum > target) {
				reject = true;
			}
			for(int i = 0; i < combo.size() - 1; i++) {
				if(combo.get(i) > combo.get(i + 1)) {
					reject = true;
					break;
				}
			}
			return reject;
		}

		private boolean accept(int target, List<Integer> combo) {
			boolean accept = false;
			if(getSum(combo) == target) {
				accept = true;
			}
			return accept;
		}

		private int getSum(List<Integer> integers) {
			int sum = 0;
			for(int i = 0; i < integers.size(); i++) {
				sum += integers.get(i);
			}
			return sum;
		}
	}

}
