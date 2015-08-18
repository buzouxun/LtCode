package medium;

import java.util.Arrays;

public class ID_090_RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		ID_090_RemoveDuplicatesfromSortedArrayII problem = new ID_090_RemoveDuplicatesfromSortedArrayII();
		int[] test = new int[]{};
		test = new int[]{1, 1, 1, 2, 2, 3, 3};
		System.out.println(problem.new Solution().removeDuplicates(test) + ", " + Arrays.toString(test));
	}

	class Solution {
		public int removeDuplicates(int[] nums) {
			int length = -1;
			if(nums.length <= 1) {
				length = nums.length;
			}
			else {
				Arrays.sort(nums);
				int head = 0;
				int sec = -1;
				for(int i = 1; i < nums.length; i++) {
					if(nums[i] == nums[head]) {
						if(sec == -1) {
							if(i - head > 1) {
								swap(nums, i, head + 1);
							}
							sec = head + 1;
						}
					}
					else {
						if(sec == -1) {
							sec = head;
						}
						swap(nums, i, sec + 1);
						head = sec + 1;
						sec = -1;
					}
				}
				length = head + 1;
				if(sec != -1) {
					length = sec + 1;
				}
			}
			return length;
		}
		
		private void swap(int[] array, int index1, int index2) {
			int tmp = array[index1];
			array[index1] = array[index2];
			array[index2] = tmp;
		}
	}

}
