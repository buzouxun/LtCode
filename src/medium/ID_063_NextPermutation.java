package medium;

import java.util.Arrays;

public class ID_063_NextPermutation {

	public static void main(String[] args) {
		ID_063_NextPermutation problem = new ID_063_NextPermutation();

		//		int[] test = null;
		//		test = new int[]{1, 2, 3, 4, 5};
		//		problem.new Solution().nextPermutation(test);
		//		System.out.println("[1, 2, 3, 4, 5] -> " + test);
		//		test = new int[]{3, 2, 1};
		//		problem.new Solution().nextPermutation(test);
		//		System.out.println("[3, 2, 1] -> " + test);
		//		test = new int[]{1, 2, 4, 3, 5};
		//		problem.new Solution().nextPermutation(test);
		//		System.out.println("[1, 2, 4, 3, 5] -> " + test);
		//		test = new int[]{1, 2, 4, 5, 3};
		//		problem.new Solution().nextPermutation(test);
		//		System.out.println("[1, 2, 4, 5, 3] -> " + test);

	}

	class Solution {
		public void nextPermutation(int[] nums) {
			if(nums.length == 1) {
				// do nothing
			}
			else {
				// find first number
				int firstNumberIndex = findFirstNumber(nums);
				if(firstNumberIndex == -1) {
					// 3, 2, 1 -> 1, 2, 3
					Arrays.sort(nums);
				}
				else {
					// find second number 
					int secondNumberIndex = findSecondNumber(nums, firstNumberIndex);
					// swap two numbers
					swap(nums, firstNumberIndex, secondNumberIndex);
					// sort rest of numbers
					sort(nums, firstNumberIndex);
				}
			}
		}

		private void sort(int[] nums, int index) {
			if(index == nums.length - 1 || index == nums.length - 2) {
				// do nothing
			}
			else {
				Arrays.sort(nums, index + 1, nums.length);
			}			
		}

		private void swap(int[] nums, int index1, int index2) {
			int tmp = 0;
			tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = tmp;			
		}

		private int findFirstNumber(int[] nums) {
			int length = nums.length;
			int index = -1;;
			for(int i = length - 1; i > 0; i--) {
				if(nums[i - 1] < nums[i]) {
					index = i - 1;
					break;
				}
			}
			return index;
		}

		private int findSecondNumber(int[] nums, int firstNumberIndex) {
			int length = nums.length;
			int index = -1;
			for(int i = firstNumberIndex + 1 ; i < length; i++) {
				if(nums[i] > nums[firstNumberIndex]) {
					index = i;
				}
			}
			if(index == -1) {
				index = length - 1;
			}
			return index;
		}
	}

}
