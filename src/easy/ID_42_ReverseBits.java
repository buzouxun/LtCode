package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_42_ReverseBits {

	public static void main(String[] args) {
		ID_42_ReverseBits problem = new ID_42_ReverseBits();
		int test = 0;

		// 0111 -> 1110
		System.out.println(problem.new Solution().reverseBits(1));

	}

	class Solution {
		// you need treat n as an unsigned value
		public int reverseBits(int n) {
			int res = 0;
			// concat n's ith digit with res
			//			for (int i = 0; i < 32; i++) {
			//				res = (res << 1) ^ ((n >>> i) & 1);
			//			}
			res = reverseBitsOptimized(n);
			return res;		
		}
	}

	private static Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

	public static int reverseBitsOptimized(int n) {
		int res = 0;
		byte[] fourBytes = new byte[4];
		for(int i = 0; i < 4; i++) {
			fourBytes[i] = (byte)((n >>> (8 * i)) & 255);
		}
		for(int i = 0; i < 4; i++) {
			res = (res << 8) ^ (reverseBytes(fourBytes[i]));
		}		
		return res;
	}

	public static int reverseBytes(byte b) {
		if (cache.containsKey(b)) return cache.get(b);
		int res = 0;
		for (int i = 0; i < 8; i++) {
			res = (res << 1) ^ ((b >>> i) & 1);
		}
		cache.put(b, res);
		return res;
	}


}
