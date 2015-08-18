package medium;

import java.util.Arrays;

public class ID_086_SortColors {

	public static void main(String[] args) {		
		ID_086_SortColors problem = new ID_086_SortColors();
		
		int[] test = new int[]{0,1,0,2,0,1,2,0};
		problem.new Solution().sortColors(test);
		System.out.println(Arrays.toString(test));
	}

	class Solution {
		public void sortColors(int[] nums) {
			int firstOne = -1;
			int firstTwo = -1;
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == 0) {
//					System.out.println("nums[i] == 0: START - " + Arrays.toString(nums));
					if(firstOne == -1 && firstTwo == -1) {
						// do nothing
					}
					else if(firstOne == -1 && firstTwo != -1) {
						swap(nums, firstTwo, i);
						if(i - firstTwo > 1) {
							firstTwo ++;
						}
						else {
							firstTwo = i;
						}
					}
					else if(firstOne != -1 && firstTwo == -1) {
						swap(nums, firstOne, i);
						if(i - firstOne > 1) {
							firstOne ++;
						}
						else {
							firstOne = i;
						}
					}
					else {
						swap(nums, firstOne, i);
						if(i - firstOne > 1 && nums[firstOne + 1] == 1) {
							firstOne ++;
						}
						else {
							firstOne = -1;
						}
						i --;
					}
//					System.out.println("nums[i] == 0: END - " + Arrays.toString(nums));
				}
				else if(nums[i] == 1) {
//					System.out.println("nums[i] == 1: START - " + Arrays.toString(nums));
					if(firstTwo == -1) {
						if(firstOne == -1) {
							firstOne = i;
						}
					}
					else {
						swap(nums, firstTwo, i);
						if(firstOne == -1) {
							firstOne = firstTwo;
						}
						if(i - firstTwo > 1) {
							firstTwo ++;
						}
						else {
							firstTwo = i;
						}						
					}
//					System.out.println("nums[i] == 1: END - " + Arrays.toString(nums));
				}
				else if(nums[i] == 2) {
					if(firstTwo == -1) {
						firstTwo = i;
					}
				}
			}
		}

		private void swap(int[] nums, int index1, int index2) {
			int tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = tmp;
		}
	}

}
