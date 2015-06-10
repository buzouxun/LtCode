package easy;

public class ID_10_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		ID_10_RemoveDuplicatesFromSortedArray problem = new ID_10_RemoveDuplicatesFromSortedArray();
		int test = -1;
		
		// [1, 1, 2, 3]
		int[] input = new int[]{1, 1, 2, 3};
		test = problem.new Solution().removeDuplicates(input);
		System.out.println("[1, 1, 2] -> [" + input[0] + ", " + input[1] + ", " + input[2] + "]");
		

	}

	class Solution {
		public int removeDuplicates(int[] nums) {
			int len = 1;
			int numSkippedNums = 0;
			int old_len = nums.length;
			if(old_len == 0 || old_len == 1) {
				len = old_len;
			}
			else {
				int i = 0;
				for(int j = 1; j < old_len; j++) {
					if(nums[j] == nums[i]) {
						numSkippedNums ++;
					}
					else {
						// move number
						nums[j - numSkippedNums] = nums[j];
						len ++;
						i = j;
					}
				}
			}
			return len;
		}
	}

}
