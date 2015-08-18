package medium;

public class ID_091_SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public boolean search(int[] nums, int target) {
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == target) {
					return true;
				}
			}
			return false;
		}
	}
	
}
