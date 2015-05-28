package easy;

public class ID_04_PalindromeNumber {

	public static void main(String[] args) {
		ID_04_PalindromeNumber problem = new ID_04_PalindromeNumber();
		boolean test = false;

		// 1 -> true
		test = problem.new Solution().isPalindrome(1);
		System.out.println("1 -> true = " + test);

		// 101 -> true
		test = problem.new Solution().isPalindrome(101);
		System.out.println("101 -> true = " + test);

		// 1001 -> true
		test = problem.new Solution().isPalindrome(1001);
		System.out.println("1001 -> true = " + test);

		// 10 -> false
		test = problem.new Solution().isPalindrome(10);
		System.out.println("10 -> false = " + test);

		// 1410110141 -> true
		test = problem.new Solution().isPalindrome(1410110141);
		System.out.println("1410110141 -> true = " + test);

		// 2147483647 -> false
		test = problem.new Solution().isPalindrome(2147483647);
		System.out.println("2147483647 -> false = " + test);
		
		// 1244554421 -> true
		test = problem.new Solution().isPalindrome(1244554421);
		System.out.println("1244554421 -> true = " + test);
	}

	class Solution {
		public boolean isPalindrome(int x) {
			boolean sol = true;
			if (x < 0) {
				sol = false;
			}
			else {
				// number of digits for finding the most significant digit
				int numDigits = 0;
				while(x / ((int) Math.pow(10, numDigits)) > 9) {					
					numDigits ++;
				}
				numDigits++;
				while(x > 0) {
					long mostSigDigit = x / ((int)Math.pow(10, numDigits-1));					
					long leastSigDigit = x % 10;
					if (mostSigDigit != leastSigDigit) {						
						sol = false;
						break;
					}
					x = (x % ((int)Math.pow(10, numDigits-1))) / 10;
					numDigits  -= 2;
				}
			}
			return sol;
		}
	}
}
