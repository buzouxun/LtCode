package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_18_ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		public int climbStairs(int n) {
			int numDistinctWays = 0;			
			map.put(1, 1);
			map.put(2, 2);
			if(map.containsKey(n)) {
				numDistinctWays = map.get(n);
			}
			else {
				numDistinctWays = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
			}
			return numDistinctWays;
		}

		private int climbStairsHelper(int n) {
			int numDistinctWays = 0;
			if(map.containsKey(n)) {
				numDistinctWays = map.get(n);
			}
			else {
				numDistinctWays = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
				map.put(n, numDistinctWays);
			}
			return numDistinctWays;
		}
	}

}
