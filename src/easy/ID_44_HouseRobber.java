package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_44_HouseRobber {

	public static void main(String[] args) {
		ID_44_HouseRobber problem = new ID_44_HouseRobber();

		System.out.println("rob({2, 3}) = " + problem.new Solution().rob(new int[]{2, 3}));
		System.out.println("rob({2, 4, 1}) = " + problem.new Solution().rob(new int[]{2, 4, 1}));
		System.out.println("rob({2, 4, 3}) = " + problem.new Solution().rob(new int[]{2, 4, 3}));
		System.out.println("rob({2, 1, 1, 2}) = " + problem.new Solution().rob(new int[]{2, 1, 1, 2}));

	}

	/*
	 * Dynamic Programming
	 *
	 * We can easy find the recurive fomular:
	 *
	 *     dp[n] = max( 
	 *                    dp[n-1],   // the previous house has been robbed. 
	 *                    dp[n-2] + money[n]  // the previous house has NOT been robbed.
	 *                )
	 *                  
	 * The initalization is obvious:
	 *     dp[1] = money[1]
	 *     dp[2] = max(money[1], money[2])
	 *
	 */

	class Solution {
		public int rob(int[] nums) {
			int money = 0;
			Map<Integer, Integer> cache = new HashMap();
			if(nums.length == 0) {
				money = 0;
			}
			else {
				if(nums.length >= 1) {
					cache.put(1, nums[0]);
				}
				if(nums.length >= 2) {
					cache.put(2, Math.max(nums[0], nums[1]));
				}
				for(int i = 2; i < nums.length; i++) {
					int max = Math.max(cache.get(i - 1) + nums[i], cache.get(i));
					cache.put(i + 1, max);
				}
				money = cache.get(nums.length);
			}
			return money;
		}
	}
}
