package medium;

public class ID_064_SearchforaRange {

	public static void main(String[] args) {
		ID_064_SearchforaRange problem = new ID_064_SearchforaRange();

//		System.out.println("[5, 7, 7, 8, 8, 10], 8 -> " + problem.new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)[1]);
		System.out.println("[1], 0 -> " + problem.new Solution().searchRange(new int[]{1}, 0)[1]);

	}

	class Solution {
		public int[] searchRange(int[] nums, int target) {
			int[] res = new int[]{nums.length, -1};
			if(nums.length == 0) {
				res = new int[]{-1, -1};
			}
//			else if (nums.length == 1) {
//				if(nums[0] == target) {
//					res[0] = 0;
//					res[1] = 0;
//				}
//				else {
//					res = new int[]{-1, -1};
//				}
//			}
			else {
				int startIndex = 0;
				int endIndex = nums.length - 1;
				bs(nums, target, res,  startIndex, endIndex);
				if(res[0] == nums.length && res[1] == -1) {
					res = new int[]{-1, -1};
				}
			}
			return res;
		}

		private void bs(int[] nums, int target, int[] res, int startIndex,  int endIndex){
			int index = -1;
			if(endIndex - startIndex > 1) {
				index = (startIndex + endIndex) / 2;
				int num = nums[index];
				if(num < target) {
					System.out.println("index <= " + index);
					bs(nums, target, res, index, endIndex);	
				}
				else if(num > target) {
					System.out.println("index >= " + index);
					bs(nums, target, res, startIndex, index);
				}
				else {
					System.out.println("index = " + index);
					if(index < res[0]) {
						res[0] = index;
					}
					if(index > res[1]) {
						res[1] = index;
					}
					bs(nums, target, res, startIndex, index);
					bs(nums, target, res, index, endIndex);	
				}
			}
			else {
				if(nums[startIndex] == target) {
					if(startIndex < res[0]) {
						res[0] = startIndex;
					}
					if(startIndex > res[1]) {
						res[1] = startIndex;
					}
				}
				if(nums[endIndex] == target) {
					if(endIndex < res[0]) {
						res[0] = endIndex;
					}
					if(endIndex > res[1]) {
						res[1] = endIndex;
					}
				}
			}
		}
	}

}
