package easy;

public class ID_11_RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int removeElement(int[] nums, int val) {
			int len = 0;
			if(nums.length == 0) {
				len = nums.length;
			}
			else {
				int i = 0;
				int j = nums.length;
				while(j - i != 0) {
					if(nums[i] != val) {
						len ++;
						i ++;
					}
					else {
						nums[i] = nums[j - 1];
						j --;
					}
				}
			}
			return len;
		}
	}

}
