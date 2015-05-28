package easy;

public class ID_03_atoi {

	public static void main(String[] args) {
		ID_03_atoi problem = new ID_03_atoi();
		int test = -1;

		// char has to be one of '0', '1', '2', ... , '9'

		// "0" -> 0
		test = problem.new Solution().myAtoi("0");
		System.out.println("0 = " + test);

		// "01020" -> 1020
		test = problem.new Solution().myAtoi("01020");
		System.out.println("01020 = " + test);

		// "-0" -> "0"
		test = problem.new Solution().myAtoi("-0");
		System.out.println("-0 = " + test);

		// "-01020" -> -1020
		test = problem.new Solution().myAtoi("-01020");
		System.out.println("-01020 = " + test);

		// "  -01020" -> -1020
		test = problem.new Solution().myAtoi("  -01020");
		System.out.println("  -01020 = " + test);

		// "123  456" -> 123
		test = problem.new Solution().myAtoi("123  456");
		System.out.println("123  456 = " + test);

		// "   +0 123" -> 123
		test = problem.new Solution().myAtoi("   +0 123");
		System.out.println("   +0 123 = " + test);

		// "9223372036854775809" -> 2147483647
		test = problem.new Solution().myAtoi("9223372036854775809");
		System.out.println("9223372036854775809 = " + test);

		// overflow

		// DEBUG
		// System.out.println("+123 = " + Integer.parseInt("+123"));
		// System.out.println("+0123 = " + Integer.parseInt("+0123"));
		// System.out.println("-0123 = " + Integer.parseInt("-0123"));

	}

	class Solution {
		public int myAtoi(String str) {
			boolean detectFirstDigit = false;
			boolean negativeIntger = false;
			long sol = 0;
			for(int charIndex = 0; charIndex < str.length(); charIndex++) {
				char c = str.charAt(charIndex);
				if(c == ' ' && !detectFirstDigit) {
					// do nothing
				}
				else if(c == '+' && !detectFirstDigit){
					detectFirstDigit = true;
				}
				else if(c == '-' && !detectFirstDigit){
					negativeIntger = true;	
					detectFirstDigit = true;
				}
				else {
					int i = (int) c - 48;					
					if(i>=0 && i <=9) {
						detectFirstDigit = true;
						sol = 10 * sol + i;
						if(negativeIntger && sol * (-1) <= Integer.MIN_VALUE) {
							sol = Integer.MIN_VALUE;
							negativeIntger = false;
							break;
						}
						else if(sol >= Integer.MAX_VALUE) {
							sol = Integer.MAX_VALUE;
							break;
						}
					}
					else{
						break;
					}					
				}
			}
			if(negativeIntger) {
				sol *= -1;
			}
			return (int) sol;
		}
	}

}
