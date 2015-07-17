package easy;

public class ID_42_ReverseBits {

	public static void main(String[] args) {
		ID_42_ReverseBits problem = new ID_42_ReverseBits();
		int test = 0;
		
		// 0111 -> 1110
//		System.out.println(problem.new Solution().reverseBits(1));
		
		System.out.println((7 >>> 1) & 1);
		
	}

	class Solution {
		// you need treat n as an unsigned value
		public int reverseBits(int n) {
			int res = 0;
			// concat n's ith digit with res
			for (int i = 0; i < 32; i++) {
				res = (res << 1) ^ ((n >>> i) & 1);
			}
			return res;		
		}
	}

}
