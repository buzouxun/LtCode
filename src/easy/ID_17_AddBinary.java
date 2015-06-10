package easy;

public class ID_17_AddBinary {

	public static void main(String[] args) {
		ID_17_AddBinary problem = new ID_17_AddBinary();
		String a = "1010";
		String b = "1111";

		System.out.println(problem.new Solution().addBinary(a, b));

	}

	class Solution {
		public String addBinary(String a, String b) {
	        int carry = 0;
	        String res = "";
	        int i = 0;
	        while (i < a.length() || i < b.length()) {
	            int p = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
	            int q = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
	            int tmp = p + q + carry;
	            carry = tmp / 2;
	            res = tmp % 2 + res;
	            i++;
	        }
	        return carry == 0 ? res : "1" + res;

	        /*
			String sum = "";
			int length = a.length() > b.length() ? a.length() : b.length();
			int numDigitComputed = 0;
			boolean carry[] = new boolean[]{false};
			char sumDigit[] = new char[]{'0'};
			char firstDigit = '0';
			char secondDigit = '0';
			while(numDigitComputed < length) {
				firstDigit = numDigitComputed < a.length() ? a.charAt(a.length() - 1 - numDigitComputed) : '0';
				secondDigit = numDigitComputed < b.length() ? b.charAt(b.length() - 1 - numDigitComputed) : '0';
				addTwoBinaryDigits(firstDigit, secondDigit, carry, sumDigit);
				sum = String.valueOf(sumDigit) + sum;
				numDigitComputed ++;
			}
			if(carry[0]) {
				sum = "1" + sum;
			}
			return sum;
			*/
		}

		/*
		private void addTwoBinaryDigits(char firstDigit, char secondDigit, boolean[] carry, char[] sumDigit) {
			char zero = '0';
			char one = '1';
			if(firstDigit == zero && secondDigit == zero && !carry[0]) {
				sumDigit[0] = zero;
				carry[0] = false;
			}
			else if(firstDigit == one && secondDigit == zero && !carry[0]) {
				sumDigit[0] = one;
				carry[0] = false;				
			}
			else if(firstDigit == zero && secondDigit == one && !carry[0]) {
				sumDigit[0] = one;
				carry[0] = false;
			}
			else if(firstDigit == one && secondDigit == one && !carry[0]) {
				sumDigit[0] = zero;
				carry[0] = true;
			}
			else if(firstDigit == zero && secondDigit == zero && carry[0]) {
				sumDigit[0] = one;
				carry[0] = false;
			}
			else if(firstDigit == one && secondDigit == zero && carry[0]) {
				sumDigit[0] = zero;
				carry[0] = true;
			}
			else if(firstDigit == zero && secondDigit == one && carry[0]) {
				sumDigit[0] = zero;
				carry[0] = true;
			}
			else if(firstDigit == one && secondDigit == one && carry[0]) {
				sumDigit[0] = one;
				carry[0] = true;
			}
		}
		*/
	}
}
