package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_45_HappyNumber {

	public static void main(String[] args) {
		ID_45_HappyNumber problem = new ID_45_HappyNumber();
		
		System.out.println("isHappy(91) = " + problem.new Solution().isHappy(91));
//		System.out.println("isHappy(2) = " + problem.new Solution().isHappy(2));

	}

	class Solution {
		public boolean isHappy(int n) {
			boolean happy = false;
			Map<Integer, Boolean> integers = new HashMap();
			int sumSqureOfDigits = sumSqureOfDigits(n);
			while(integers.containsKey(sumSqureOfDigits) == false && sumSqureOfDigits != 1) {
				System.out.println("sumSqureOfDigits = " + sumSqureOfDigits);
				integers.put(sumSqureOfDigits, true);
				sumSqureOfDigits = sumSqureOfDigits(sumSqureOfDigits);
			}
			if(sumSqureOfDigits == 1) {
				happy = true;
			}
			return happy;
		}
		
		private int sumSqureOfDigits(int n) {
			int sum = 0;
			while(n >= 10) {
				int digit = n % 10;
				sum += digit * digit;
				n = n / 10;
			}
			sum += n * n;
			return sum;
		}
	}

}
