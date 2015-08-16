package medium;

public class ID_081_MinimumPathSum {

	public static void main(String[] args) {
		ID_081_MinimumPathSum problem = new ID_081_MinimumPathSum();

		System.out.println("{ {0,0,0}, {0,0,0}, {0,0,0} } -> " + problem.new Solution().minPathSum(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
	}

	class Solution {
		public int minPathSum(int[][] grid) {
			if(grid == null || grid.length == 0 || grid[0].length == 0) {
				return 0;
			}
			else {
				int[][] boolGrid = new int[grid.length][grid[0].length];
				boolGrid[0][0] = 1;
				return helper(grid, grid.length - 1, grid[0].length - 1, boolGrid);
			}
		}

		private int helper(int[][] grid, int y, int x, int[][] boolGrid) {
			if(x == 0 && y == 0) {
				return 0 + grid[y][x];
			}
			else if(x < 0 || y < 0) {
				return Integer.MAX_VALUE;
			}
			else {
				if(boolGrid[y][x] == 1) {
					return grid[y][x];
				}
				else {
					int upMinSum = helper(grid, y - 1, x, boolGrid);
					int leftMinSum = helper(grid, y, x - 1, boolGrid);
					int minSum = Math.min(upMinSum, leftMinSum);
					grid[y][x] += minSum;
					boolGrid[y][x] = 1;
					return grid[y][x];
				}
			}
		}
	}
}
