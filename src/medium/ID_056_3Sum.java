package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ID_056_3Sum {

	public static void main(String[] args) {
		ID_056_3Sum problem = new ID_056_3Sum();

		//System.out.println("{-1 0 1 -1 -4} = " + problem.new Solution().threeSum(new int[]{-1, 0, 1, -1, -4}).toString());
		//System.out.println("{-1 2 -1 -4} = " + problem.new Solution().threeSum(new int[]{-1, 2, -1, -4}).toString());
		System.out.println("[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6] = " + problem.new Solution().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
		//System.out.println("Time limite = " + problem.new Solution().threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
		//System.out.println("Time 2 = " + problem.new Solution().threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
	}

	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> res = new LinkedList<>(); 
			for (int i = 0; i < nums.length-2; i++) {
				if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
					int lo = i + 1;
					int hi = nums.length - 1;
					int sum = 0 - nums[i];
					while (lo < hi) {
						if (nums[lo] + nums[hi] == sum) {
							res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
							while (lo < hi && nums[lo] == nums[lo+1]) lo++;
							while (lo < hi && nums[hi] == nums[hi-1]) hi--;
							lo++; hi--;
						} else if (nums[lo] + nums[hi] < sum) {
							// improve: skip duplicates
							while (lo < hi && nums[lo] == nums[lo+1]) lo++;
							lo++;
						} else {
							// improve: skip duplicates
							while (lo < hi && nums[hi] == nums[hi-1]) hi--;
							hi--;
						}
					}
				}
			}
			return res;
		}


		// My solution using Hashmap
		//		public List<List<Integer>> threeSum(int[] nums) {
		//			List<List<Integer>> sum = new ArrayList<List<Integer>>();
		//			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//			Map<String, Integer> existed3Sum = new HashMap<String, Integer>();
		//			for(int i = 0; i < nums.length; i++) {
		//				if(nums[i] > 0) {
		//					map.put(0 - nums[i], i);
		//				}
		//			}
		//			for(int i = 0; i < nums.length; i++) {
		//				if(nums[i] <= 0) {
		//					for(int j = i + 1; j < nums.length; j++) {
		//						if(nums[i] + nums[j] < 0) {
		//							int num1 = nums[i] + nums[j];
		//							if(map.containsKey(num1)) {
		//								int index = map.get(num1);
		//								if(index != i && index != j) {
		//									List<Integer> sorted3Nums = sort3nums(nums[i], nums[j], 0 - nums[i] - nums[j]);
		//									if(existed3Sum.containsKey(sorted3Nums.toString())) {
		//
		//									}
		//									else {
		//										sum.add(sorted3Nums);
		//										existed3Sum.put(sorted3Nums.toString(), 0);
		//									}
		//								}
		//							}
		//						}
		//					}
		//				}
		//			}			
		//			return sum;
		//		}
		//		
		//		private List<Integer> sort3nums(int num1, int num2, int num3) {
		//			List<Integer> sorted3Nums = new ArrayList<Integer>();
		//			int min = 0;
		//			int max = 0;
		//			min = Math.min(num1, num2);
		//			min = Math.min(min, num3);
		//			max = Math.max(num1, num2);
		//			max = Math.max(max, num3);
		//			sorted3Nums.add(min);
		//			sorted3Nums.add(0 - min - max);
		//			sorted3Nums.add(max);
		//			return sorted3Nums;
		//		}
	}
}
