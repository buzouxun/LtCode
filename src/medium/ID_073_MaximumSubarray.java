package medium;

public class ID_073_MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	class Solution {
		public int maxSubArray(int[] nums) {
			if(nums.length == 0) {
				return 0;
			}
			int max = nums[0];
			int currentMax = nums[0];
			for(int i = 1; i < nums.length; i++) {
				currentMax = Math.max(nums[i], currentMax + nums[i]);
				max = Math.max(currentMax, max);
			}
			return max;
		}
	}

}
