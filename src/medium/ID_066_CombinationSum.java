package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ID_066_CombinationSum {

	public static void main(String[] args) {
		ID_066_CombinationSum problem = new ID_066_CombinationSum();

		// [2,3,6,7], 7 -> [2, 2, 3], [7]
		System.out.println("[2,3,6,7], 7 -> " + problem.new Solution().combinationSum(new int[]{2,3,6,7}, 7) );

	}

	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> res = new ArrayList<List<Integer>> ();
			List<Integer> combo = new LinkedList<Integer> ();
			bt(candidates, target, res, combo);
			return res;
		}

		private void bt(int[] candidates, int target, List<List<Integer>> res, List<Integer> combo) {
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
			while(i < choices.length) {
				List<Integer> newCombo = new LinkedList<Integer>(combo);
				newCombo.add(choices[i]);
				bt(candidates, target, res, newCombo);
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
