package medium;

public class ID_101_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		ID_101_UniqueBinarySearchTrees problem = new ID_101_UniqueBinarySearchTrees();
		System.out.println(problem.new Solution().numTrees(3));
	}
	
	class Solution {
		
		// dp[1] = dp[0]
		// dp[2] = dp[0] * dp[1] + dp[0] * dp[1]
		// dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
		
	    public int numTrees(int n) {
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        for(int i = 1; i <= n; i ++) {
	        	for(int j = 0; j <= i - 1; j ++) {
	        		dp[i] += dp[j] * dp[i - 1 - j];
	        	}
	        }	        
	        return dp[n];
	    }
	}

}
