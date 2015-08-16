package medium;

public class ID_082_SqrtX {

	public static void main(String[] args) {
		ID_082_SqrtX problem = new ID_082_SqrtX();

		//		System.out.println("sqrt(1) = " + problem.new Solution().mySqrt(1));
		//		System.out.println("sqrt(2) = " + problem.new Solution().mySqrt(2));
		//		System.out.println("sqrt(3) = " + problem.new Solution().mySqrt(3));
		//		System.out.println("sqrt(4) = " + problem.new Solution().mySqrt(4));
		//		System.out.println("sqrt(5) = " + problem.new Solution().mySqrt(5));
		//		System.out.println("sqrt(9) = " + problem.new Solution().mySqrt(9));
		//		System.out.println("sqrt(10) = " + problem.new Solution().mySqrt(10));
		//		System.out.println("sqrt(15) = " + problem.new Solution().mySqrt(15));
		//		System.out.println("sqrt(16) = " + problem.new Solution().mySqrt(16));
		//		System.out.println("sqrt(17) = " + problem.new Solution().mySqrt(17));
	}

	class Solution {
		public int mySqrt(int x) {
			if(x == 0) {
				return 0;
			}
			else if(x == 1) {
				return 1;
			}
			else {
				long min = 0;
				long max = x;
				int guess = (int) Math.floor((min + max) / 2L);
				while(guess != 0 && !(guess <= x / guess && (guess + 1) > x / (guess + 1))) {
					// make new guess
					if(x / guess > guess) {
						min = guess;
						guess = (int) Math.floor((min + max) / 2L);
					}
					else {
						max = guess;
						guess = (int) Math.floor((min + max) / 2L);	        			
					}
				}
				return guess;
			}
		}
	}
}
