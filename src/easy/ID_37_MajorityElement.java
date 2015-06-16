package easy;

public class ID_37_MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int majorityElement(int[] nums) {
			int majorEle = 0;
			int count = 0;
			for(int i = 0; i < nums.length; i++) {
				if(count == 0) {
					majorEle = nums[i];
					count = 1;
				}
				else if(count > Math.floor(nums.length / 2)) {
					break;
				}
				else {
					if(majorEle == nums[i]) {
						count ++;
					}
					else {
						count --;
					}
				}
			}
			return majorEle;
		}
	}
}
