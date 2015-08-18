package hard;

public class ID_158_SearchinRotatedSortedArray {

	public static void main(String[] args) {
		ID_158_SearchinRotatedSortedArray problem = new ID_158_SearchinRotatedSortedArray();		
		//		System.out.println(problem.new Solution().search(new int[]{1,2,3,4,5,6}, 4));
		//		System.out.println(problem.new Solution().search(new int[]{4,5,6,1,2,3}, 6));
		//		System.out.println(problem.new Solution().search(new int[]{3,1}, 0));
		System.out.println(problem.new Solution().search(new int[]{4,5,6,7,8,1,2,3}, 8));
	}

	class Solution {

		// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2)

		public int search(int[] nums, int target) {
			int res = -1;
			if(nums.length == 1) {
				if(nums[0] == target) {
					res = 0;
				}
			}
			else {
				int head = 0;
				int tail = nums.length - 1;
				res = helper(nums, head, tail, target);
			}
			return res;
		}

		private int helper(int[] nums, int head, int tail, int target) {
			int ans = -1;
			if(nums[head] < nums[tail]) {
				while(tail - head > 1) {
					int guess = (int) Math.floor((head + tail) / 2);
					if(nums[guess] < target) {
						head = guess;
					}
					else if(nums[guess] > target) {
						tail = guess;
					}
					else {
						ans = guess;
						break;
					}
				}
				if(ans == -1) {
					if(nums[head] == target) {
						ans = head;
					}
					else if(nums[tail] == target) {
						ans = tail;
					}
				}
			}
			else {
				if(tail - head <= 1) {
					if(nums[head] == target) {
						ans = head;
					}
					else if(nums[tail] == target) {
						ans = tail;
					}
				}
				else {
					int guess = (head + tail) / 2;
					if(target >= nums[head]) {
						if(target >= nums[guess] && nums[guess] > nums[head]) {
							ans = helper(nums, guess, tail, target);
						}
						else {
							ans = helper(nums, head, guess, target);
						}
					}
					else if(target <= nums[tail]) {
						if(target <= nums[guess] && nums[guess] < nums[tail]) {
							ans = helper(nums, head, guess, target);
						}
						else {
							ans = helper(nums, guess, tail, target);
						}
					}
				}
			}			
			return ans;
		}
	}
}
