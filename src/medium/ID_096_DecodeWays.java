package medium;

public class ID_096_DecodeWays {

	public static void main(String[] args) {
		ID_096_DecodeWays problem = new ID_096_DecodeWays();
				System.out.println(problem.new Solution().numDecodings("100"));
//		long start = System.currentTimeMillis();
//		System.out.println(problem.new Solution().numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
	}

	class Solution {
		// 0
		// 1 ~ 9     - A
		// 10        - B
		// 11 ~ 19   - C
		// 20        - D
		// 21 ~ 26   - E

		public int numDecodings(String s) {
			int n = s.length();
			if (n == 0) return 0;
			int[] memo = new int[n+1];
			memo[n]  = 1;
			memo[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
			for (int i = n - 2; i >= 0; i--) {
				if (s.charAt(i) == '0') continue;
				else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
			}
			return memo[0];			
			//						int numWays = 0;
			//						if(s.length() == 0) {
			//						}
			//						else {
			//							int[] ways = new int[]{0};
			//							String decode = "";
			//							helper(s, decode, ways);
			//							numWays = ways[0];
			//						}
			//						return numWays;
		}

		private void helper(String encode, String decode, int[] ways) {
			// reject
			if(encode.length() > 0) {
				String firstDigit = encode.substring(0, 1);
				if(firstDigit.equals("0")) {
					return;
				}
			}
			// accept
			if(encode.length() == 0) {
				ways[0] ++;
				return;
			}			
			if(encode.length() == 1) {
				if(!encode.equals("0")) {
					String new_decode = decode + "A";
					String new_encode = "";
					helper(new_encode, new_decode, ways);
				}
			}
			else {
				String firstDigit = encode.substring(0, 1);
				String secondDigit = encode.substring(1, 2);
				if(Integer.valueOf(firstDigit) == 0) {
					// ignore
				}
				else if(Integer.valueOf(firstDigit) == 1) {
					if(secondDigit.equals("0")) {
						String new_decode = decode + "B";
						String new_encode = encode.substring(2, encode.length());;
						helper(new_encode, new_decode, ways);
					}
					else {
						String new_decode = decode + "A";
						String new_encode = encode.substring(1, encode.length());;
						helper(new_encode, new_decode, ways);
						String new_decode2 = decode + "C";
						String new_encode2 = encode.substring(2, encode.length());;
						helper(new_encode2, new_decode2, ways);
					}
				}
				else if(Integer.valueOf(firstDigit) == 2) {
					if(secondDigit.equals("0")) {
						String new_decode = decode + "D";
						String new_encode = encode.substring(2, encode.length());;
						helper(new_encode, new_decode, ways);
					}
					else if(Integer.valueOf(firstDigit + secondDigit) >= 21 && Integer.valueOf(firstDigit + secondDigit) <= 26){
						String new_decode = decode + "A";
						String new_encode = encode.substring(1, encode.length());;
						helper(new_encode, new_decode, ways);
						String new_decode2 = decode + "E";
						String new_encode2 = encode.substring(2, encode.length());;
						helper(new_encode2, new_decode2, ways);
					}
					else {
						String new_decode = decode + "A";
						String new_encode = encode.substring(1, encode.length());;
						helper(new_encode, new_decode, ways);						
					}
				}
				else {
					String new_decode = decode + "A";
					String new_encode = encode.substring(1, encode.length());;
					helper(new_encode, new_decode, ways);
				}
			}
		}

	}

}
