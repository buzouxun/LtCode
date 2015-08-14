package medium;

public class ID_079_UniquePaths {

	public static void main(String[] args) {
		ID_079_UniquePaths problem = new ID_079_UniquePaths();
		
		System.out.println("1, 1 -> " +  problem.new Solution().uniquePaths(1, 1));
		System.out.println("2, 2 -> " +  problem.new Solution().uniquePaths(2, 2));
		System.out.println("1, 10 -> " +  problem.new Solution().uniquePaths(1, 10));
		System.out.println("23, 12 -> " +  problem.new Solution().uniquePaths(23, 12));
	}

	class Solution {
		
		int[][] grid = new int[100][100];
		
		public int uniquePaths(int m, int n) {
			if(m == 0 || n == 0) {
				return 0;
			}
			int numUniquePaths = 0;
			grid[0][0] = 1;
			numUniquePaths = helper(m - 1, n - 1);
			return numUniquePaths;
		}

		private int helper(int y, int x) {
			if(grid[y][x] == 0) {
				int[] left = new int[]{y, x - 1};
				int[] up = new int[]{y - 1, x};
				int numLeft = 0;
				int numUp = 0;
				if(left[0] >= 0 && left[1] >=0) {
					numLeft = helper(left[0], left[1]);
				}
				if(up[0] >= 0 && up[1] >= 0) {
					numUp = helper(up[0], up[1]);
				}
				grid[y][x] = numUp + numLeft;
				return numUp + numLeft;
			}
			else {
				return grid[y][x];
			}
		}
	}

}
