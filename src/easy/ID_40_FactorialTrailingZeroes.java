package easy;

public class ID_40_FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int trailingZeroes(int n) {
			int numZeros = 0;
			while(n > 0) {
				n = (int) Math.floor(n / 5);
				numZeros += n;
			}
			return numZeros;
		}
	}

}
