package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ID_069_Permutations {

	public static void main(String[] args) {
		ID_069_Permutations problem = new ID_069_Permutations();

		System.out.println("[1, 2] -> " + problem.new Solution().permute(new int[]{1, 2}));
		System.out.println("[1, 2, 3] -> " + problem.new Solution().permute(new int[]{1, 2, 3}));

	}

	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> permutations = new ArrayList<List<Integer>> ();
			Integer[] num = new Integer[nums.length];
			int index = 0;
			bt(permutations, nums, num, index);
			return permutations;
		}

		private void bt(List<List<Integer>> permutations, int[] choices, Integer[] num, int index) {
			if(reject(choices)) {

			}
			if(accept(choices)) {
				List<Integer> permutation = Arrays.asList(num);
				permutations.add(permutation);
			}
			// first
			int i = 0;

			while(i < choices.length) {
				Integer[] new_num = num.clone();
				new_num[index] = choices[i];
				int[] new_choices = new int[choices.length - 1];
				for(int j = 0, k = 0; j < choices.length; j++) {
					if(j == i) {
						j ++;
					}
					if(j < choices.length) {
						new_choices[k] = choices[j];
					}
					k ++;
				}
				int new_index = index + 1;
				bt(permutations, new_choices, new_num, new_index);				
				// next
				i ++;
			}
		}

		private boolean accept(int[] choices) {
			boolean accept = false;
			if(choices.length == 0) {
				accept = true;
			}
			return accept;
		}

		private boolean reject(int[] choices) {
			boolean reject = false;

			return reject;
		}
	}

}
