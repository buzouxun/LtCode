package medium;

import java.util.HashMap;
import java.util.Map;

public class ID_050_TwoSum {

	public static void main(String[] args) {
		ID_050_TwoSum problem = new ID_050_TwoSum();

		System.out.println("[-3, 4, 3] 0 -> " + problem.new Solution().twoSum(new int[]{-3, 4, 3}, 0)[0]  );

	}

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
			int[] res = new int[]{0, 0};
			for(int i = 0; i < nums.length; i++) {
				int tmp = nums[i];

				// find if tmp is key in hashmap
				if(cache.containsKey(tmp)) {
					res[0] = cache.get(tmp) + 1;
					res[1] = i + 1;
					break;
				}			
				else {
					// save (target - tmp) in hashmap
					int tmp2 = target - tmp;
					cache.put(tmp2, i);
				}
			}
			return res;
		}
	}

}
