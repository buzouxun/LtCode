package medium;

import java.util.*;

public class ID_094_GrayCode {

	public static void main(String[] args) {
		ID_094_GrayCode problem = new ID_094_GrayCode();

		System.out.println(problem.new Solution().grayCode(3));

	}

	class Solution {
		public List<Integer> grayCode(int n) {
			List<Integer> res = new ArrayList<Integer>();
			if(n == 0) {
				res.add(0);
			}
			else if(n == 1) {
				res.add(0);
				res.add(1);
			}
			else {
				int[] code = new int[n];
				res.add(binaryToDecimal(code));
				helper(res, code, n);
			}
			return res;
		}
		private void helper(List<Integer> res, int[] code, int n) {
			// first step
			int[] new_code = code.clone();
			new_code[n - 1] = new_code[n - 1] ^ 1;
			res.add(binaryToDecimal(new_code));
			// second step
			int leftToFirstOneFromRight = helper2(new_code, n);
			if(leftToFirstOneFromRight == -1) {
				return;
			}
			else {
				int[] new_code2 = new_code.clone();
				new_code2[leftToFirstOneFromRight] = new_code2[leftToFirstOneFromRight] ^ 1;
				res.add(binaryToDecimal(new_code2));
				helper(res, new_code2, n);
			}
		}
		private int helper2(int[] code, int n) {
			int index = -2;
			for(int i = n - 1; i >= 0; i--) {
				if(code[i] == 1) {
					index = i - 1;
					break;
				}
			}
			return index;
		}
		private int binaryToDecimal(int[] binary) {
			int decimal = 0;
			int tmp = 1;
			for(int i = binary.length - 1; i >= 0; i--) {
				decimal += binary[i] * tmp;
				tmp *= 2;
			}
			return decimal;
		}
	}

}
