package easy;

public class ID_41_RotateArray {

	public static void main(String[] args) {
		ID_41_RotateArray problem = new ID_41_RotateArray();
		int[] test;
		
		// [1,2], 2
		test = new int[]{1, 2};
		problem.new Solution().rotate2(test, 2);
		System.out.println("[1,2], 2 = " + test[0] + ", " +test[1]);
		
	}

	class Solution {
		public void rotate(int[] nums, int k) {
			if(k <= 0 || nums.length <= 0) {
				// do nothing
			}
			else {
				k = k % nums.length;
				int length = nums.length;
				reverseArray(nums, length - k, length - 1);
				reverseArray(nums, 0, length - k - 1);
				reverseArray(nums, 0, length -1);
			}
		}
		
		public void rotate2(int[] nums, int k) {
			if(k % nums.length == 0 || nums.length <= 1) {
				/*
				 * important conditions
				 */
				// do nothing
			}
			else {
				k = k % nums.length;
				int startIdx = 0;
				int pre = 0;
				int nxt = 0;
				int tmp1 = nums[pre];
				int tmp2 = 0;
				for(int i = 0; i < nums.length; i++) {
					nxt = (pre + k) % nums.length;
					tmp2 = nums[nxt];
					nums[nxt] = tmp1;
					tmp1 = tmp2;
					if(nxt == startIdx && startIdx + 1 < nums.length) {
						pre = startIdx + 1;
						startIdx = pre;
						tmp1 = nums[pre];
					}
					else {
						pre = nxt;
					}
				}
			}
		}
	}
	
	private void reverseArray(int[] nums, int startIdx, int endIdx) {
		int tmp;
		while(startIdx < endIdx) {
			tmp = nums[startIdx];
			nums[startIdx] = nums[endIdx];
			nums[endIdx] = tmp;
			startIdx ++;
			endIdx --;
		}
	}

}
