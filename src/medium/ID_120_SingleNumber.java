package medium;

import java.util.*;

public class ID_120_SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int singleNumber(int[] nums) {
	        int single = -1;
	        long sum = 0;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(long i = 0; i < nums.length; i++) {
	        	if(map.containsKey(nums[(int) i])) {
	        		sum -= nums[(int) i];
	        	}
	        	else {
	        		map.put(nums[(int) i], 1);
	        		sum += nums[(int) i];
	        	}
	        }
	        single = (int) sum;
	        return single;
	    }
	}

}
