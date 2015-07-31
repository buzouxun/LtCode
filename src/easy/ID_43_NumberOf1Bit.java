package easy;

public class ID_43_NumberOf1Bit {

	public static void main(String[] args) {
		ID_43_NumberOf1Bit problem = new ID_43_NumberOf1Bit();
		int test = 0;
		
		System.out.println("hammingWeight(1) = " + problem.new Solution().hammingWeight(1));
	}
	
	class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	        int cnt = 0;
	        for(int i = 0; i < 32; i++) {
	        	if(n == 0) {
	        		break;
	        	}
	        	else {
	        		int bit = (n >>> i) & 1;
	        		if(bit == 1) {
	        			cnt ++;
	        		}
	        	}
	        }
	        return cnt;
	    }
	}

}
