package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ID_059_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			if(nums.length < 4) {
				// do nothing
			}
			else {
				int i = 0;
				int j = 0;
				int low = 0;
				int high = 0;
				int length = nums.length;
				Arrays.sort(nums);
				for(i = 0; i < length - 3; i++) {
					if(i > 0 && nums[i - 1] == nums[i]) {
						// do nothing
					}
					else {
						for(j = i + 1; j < length - 2; j++) {
							if(j > i + 1 && nums[j - 1] == nums[j]) {
								// do nothing
							}
							else {
								int newTarget = target - nums[i] - nums[j];
								low = j + 1;
								high = length - 1;
								while(low < high) {
									// compare
									if(nums[low] + nums[high] == newTarget) {
										List<Integer> fourNums = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
										res.add(fourNums);
										while(low < high && nums[low] == nums[low + 1]) {
											low ++;
										}
										while(low < high && nums[high] == nums[high - 1]) {
											high --;
										}
										low ++;
										high --;
									}
									else if(nums[low] + nums[high] > newTarget) {
										while(low < high && nums[high] == nums[high - 1]) {
											high --;
										}
										high --;
									}
									else {
										while(low < high && nums[low] == nums[low + 1]) {
											low ++;
										}
										low ++;
									}
								}
							}
						}
					}
				}
			}
			return res;
		}
	}
}
