package medium;

import java.util.Arrays;

public class ID_057_3SumCloest {

	public static void main(String[] args) {
		ID_057_3SumCloest problem = new ID_057_3SumCloest();

		//System.out.println("{-1 2 1 -4}, 1 = " + problem.new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
		System.out.println("-59 = " + problem.new Solution().threeSumClosest(new int[]{13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6}, -59));
		
	}

	class Solution {
		public int threeSumClosest(int[] nums, int target) {
			int closestTarget = nums[0] + nums[1] + nums[2];
			int diff = Math.abs(target - closestTarget);
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
					int low = i + 1;
					int high = nums.length - 1;
					while(low < high) {
						int tmpTarget = nums[i] + nums[low] + nums[high];
						int tmpDiff = Math.abs(target - tmpTarget);
						if(tmpDiff < diff) {
							closestTarget = tmpTarget;
							diff = tmpDiff;
						}					
						if(tmpTarget > target) {
							high --;
						}
						else if(tmpTarget < target){
							low ++;
						}
						else {
							break;
						}
					}
				}
			}
			return closestTarget;
		}
	}

}
