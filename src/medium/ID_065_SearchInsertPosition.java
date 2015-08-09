package medium;

public class ID_065_SearchInsertPosition {

	public static void main(String[] args) {
		ID_065_SearchInsertPosition problem = new ID_065_SearchInsertPosition();

		// [1,3,5,6], 5 → 2
		// [1,3,5,6], 2 → 1
		// [1,3,5,6], 7 → 4
		// [1,3,5,6], 0 → 0 		

//		System.out.println("[1,3,5,6], 5 -> " + problem.new Solution().searchInsert(new int[]{1,3,5,6}, 5));
//		System.out.println("[1,3,5,6], 2 -> " + problem.new Solution().searchInsert(new int[]{1,3,5,6}, 2));
//		System.out.println("[1,3,5,6], 7 -> " + problem.new Solution().searchInsert(new int[]{1,3,5,6}, 7));
//		System.out.println("[1,3,5,6], 0 -> " + problem.new Solution().searchInsert(new int[]{1,3,5,6}, 0));

//		System.out.println("[1], 1 -> " + problem.new Solution().searchInsert(new int[]{1}, 1));
//		System.out.println("[1], 0 -> " + problem.new Solution().searchInsert(new int[]{1}, 0));
//		System.out.println("[0, 2], 0 -> " + problem.new Solution().searchInsert(new int[]{0, 2}, 0));
//		System.out.println("[0, 2], 2 -> " + problem.new Solution().searchInsert(new int[]{0, 2}, 2));
//		System.out.println("[0, 2], 1 -> " + problem.new Solution().searchInsert(new int[]{0, 2}, 1));
	}

	class Solution {
		public int searchInsert(int[] nums, int target) {
			int found = -1;
			if(nums.length == 0) {
				found = 0;
			}
			else {
				int startIndex = 0;
				int endIndex = nums.length - 1;
				found = bs(nums, target, startIndex, endIndex);		
			}
			return found; 
		}

		private int bs(int[] nums, int target, int startIndex, int endIndex) {
			int found = -1;
			if(Math.abs(endIndex - startIndex) <= 1) {
				if(nums[startIndex] > target) {
					found = startIndex;
				}
				else if(nums[startIndex] == target) {
					found = startIndex;
				}
				else if(nums[endIndex] >= target) {
					found = endIndex;
				}
				else if(nums[endIndex] < target) {
					found = endIndex + 1;
				}
				else {
					// System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
				}
			}
			else {
				int index = (startIndex + endIndex) / 2;
				// System.out.println("index = " + index);
				if(nums[index] == target) {
					found = index;
				}
				else if(nums[index] < target) {
					found = bs(nums, target, index, endIndex);
				}
				else if(nums[index] > target) {
					found = bs(nums, target, startIndex, index);
				}
			}			
			return found;
		}
	}
}
