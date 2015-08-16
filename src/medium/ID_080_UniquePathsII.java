package medium;

public class ID_080_UniquePathsII {

	public static void main(String[] args) {
		ID_080_UniquePathsII problem = new ID_080_UniquePathsII();
		
		System.out.println("{ {0,0,0}, {0,1,0}, {0,0,0} } -> " + problem.new Solution().uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
	}

	class Solution {
		
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
	        	return 0;
	        }
	        else {
	        	if(obstacleGrid[0][0] == 0) {
		        	obstacleGrid[0][0] = -1;
	        	}
	        	return Math.abs(helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1)); 
	        }
	    }

		private int helper(int[][] grid, int y, int x) {
			if(grid[y][x] == 1) {
				return 0;
			}
			else if(grid[y][x] == 0) {
				int numUpPaths = 0;
				int numLeftPaths = 0;
				// up
				if(x >= 0 && y - 1 >= 0) {
					numUpPaths = helper(grid, y - 1, x);
				}
				// left
				if(x - 1 >= 0 && y >= 0) {
					numLeftPaths = helper(grid, y, x - 1);
				}
				grid[y][x] = numUpPaths + numLeftPaths;
				return grid[y][x];
			}
			else {
				return grid[y][x];
			}
		}
	}
}
