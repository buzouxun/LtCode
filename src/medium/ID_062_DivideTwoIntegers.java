package medium;

public class ID_062_DivideTwoIntegers {

	public static void main(String[] args) {
		ID_062_DivideTwoIntegers problem = new ID_062_DivideTwoIntegers();

		//		System.out.println("divide(10, 3) = " + problem.new Solution().divide(10, -2));
//		System.out.println("divide(-2147483648, 2) = " + problem.new Solution().divide(-2147483648, 2));

		//		System.out.println(Integer.SIZE);  -2147483648, 2
		//		System.out.println(Integer.MAX_VALUE);
		//		System.out.println(Integer.MIN_VALUE);

		//		System.out.println(((long)2) << 31);
	}

	class Solution {
		public int divide(int dividend, int divisor) {
			int res = 0;
			if(dividend == 0) {
				res = 0;
			}
			else if(divisor == 0) {
				res = Integer.MAX_VALUE;
			}
			else if(divisor == 1) {
				res = dividend;
			}
			else if(divisor == -1) {
				res = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
			}
			else {
				boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
				long l_dividend = Math.abs((long)dividend);
				long l_divisor = Math.abs((long)divisor);
				long one = 1;
				long tmp = 0;
				for(int i = 0; i < Integer.SIZE; i++) {
					if(tmp <= l_dividend) {
						if(l_dividend - tmp < l_divisor) {
							break;
						}
						else {
							tmp += l_divisor << i;
							res += one << i;
						}
					}
					else {
						tmp -= l_divisor << (i - 1);
						res -= one << (i - 1);
						i = -1;
					}
				}
				res = sign ? res : -res;
			}
			return res;
		}
	}

}
