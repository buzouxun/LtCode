package medium;

public class ID_121_SingleNumber_II {

	public static void main(String[] args) {
		ID_121_SingleNumber_II problem = new ID_121_SingleNumber_II();

//		System.out.println("1 & 1 = " + (1 & 1));
//		System.out.println("1 & 0 = " + (1 & 0));
//		System.out.println("0 & 0 = " + (0 & 0));
		
//		System.out.println("1 | 1 = " + (1 | 1));
		
//		System.out.println("1 ^ 1 = " + (1 ^ 1));
//		System.out.println("1 ^ 0 = " + (1 ^ 0));
//		System.out.println("0 ^ 0 = " + (0 ^ 0));
		
		System.out.println(problem.new Solution().singleNumber(new int[]{1, 1, 1, 2}));
	}

	class Solution {
		// 0 -> 1 -> 0
		// 0 -> 1 -> 2 -> 0
		// 0 -> 1 -> 0 -> 0
		// 0 -> 0 -> 1 -> 0
		
		// int a = 0;
	    // int b = 0;
		// b = a & (b ^ A[j]);
        // a = b | (a ^ A[j]);
		// a = 0 -> 1 -> 1 -> 0
		// b = 0 -> 0 -> 1 -> 0
		
		public int singleNumber(int[] nums) {
			int first = 0;
			int second = 0;
			for(int i = 0; i < nums.length; i++) {
				second = first & (second ^ nums[i]);
				first = second | (first ^ nums[i]);
			}			
			int single = first;			
			return single;
		}
	}

}
