package medium;

public class ID_072_PowXY {

	public static void main(String[] args) {
		ID_072_PowXY problem = new ID_072_PowXY();
		
		System.out.println("pow(2, 7) = " + problem.new Solution().myPow(2d, 7));
	}

	class Solution {
		public double myPow(double x, int n) {
			double res = 1;
			if(n == 0) {
				return res;
			}
			if(n < 0) {
				n = -n;
				x = 1 / x;
			}
			while(n > 0) {
				if(n % 2 == 1) {
					res *= x;
				}
				x *= x;
				n = n >> 1;
//				System.out.println("res = " + res);
//				System.out.println("x = " + x);
//				System.out.println("n = " + n);
//				System.out.println("");
			}
			return res;
		}
	}

}
