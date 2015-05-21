package easy;

public class ID_2_ReverseInteger {

	public static void main(String[] args) {
		ID_2_ReverseInteger problem = new ID_2_ReverseInteger();
		int test = -1;

		// 123 -> 321
		test = problem.new Solution().reverse(123);
		System.out.println("123 = " + test);

		// 120 -> 21
		test = problem.new Solution().reverse(120);
		System.out.println("120 = " + test);

		// -123 -> -321
		test = problem.new Solution().reverse(-123);
		System.out.println("-123 = " + test);

		// -120 -> -21
		test = problem.new Solution().reverse(-120);
		System.out.println("-120 = " + test);

		// DEUBG
		// System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		// System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
	}

	class Solution {
		public int reverse(int x) {
			int sol = -1;
			long sol_long = 0;

			while(x != 0) {
				int lastDigit = x % 10;
				sol_long = sol_long * 10 + lastDigit;
				x = x /10;
			}

			if (sol_long > Integer.MAX_VALUE || sol_long < Integer.MIN_VALUE) {
				sol = 0;
			}
			else {
				sol = (int) sol_long;
			}


			return sol;
		}
	}

}
