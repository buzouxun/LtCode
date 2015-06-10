package easy;

public class ID_16_PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int[] plusOne(int[] digits) {
			int[] ans = null;
			int length = digits.length;
			int plus = 1;
			for(int i = length - 1; i >= 0; i--) {
				if(digits[i] + plus > 9) {
					digits[i] = 0;
				}
				else {
					digits[i] += plus;
					plus = 0;
					break;
				}
			}
			if(digits[0] == 0) {
				ans = new int[length + 1];
				ans[0] = 1;
				for(int i = 1; i < ans.length; i++) {
					ans[i] = digits[i - 1];
				}
			}
			else {
				ans = digits;
			}
			return ans;
		}
	}

}
