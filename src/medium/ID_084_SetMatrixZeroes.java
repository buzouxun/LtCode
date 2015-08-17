package medium;

public class ID_084_SetMatrixZeroes {

	public static void main(String[] args) {
		ID_084_SetMatrixZeroes problem = new ID_084_SetMatrixZeroes();

		problem.new Solution().setZeroes(new int[][]{{-4,-2147483648,6,-7,0}, {-8,6,-8,-6,0}, {2147483647,2,-9,-6,-10}});
	}

	class Solution {
		public void setZeroes(int[][] matrix) {
			if(matrix.length == 0 || matrix[0].length == 0) {
				// do nothing
			}
			else {
				boolean setFirstColZeros = false;
				boolean setFirstRowZeros = false;
				// first column
				for(int i = 0; i < matrix.length; i++) {
					if(matrix[i][0] == 0) {
						setFirstColZeros = true;
						break;
					}
				}
				// first row
				for(int i = 0; i < matrix[0].length; i++) {
					if(matrix[0][i] == 0) {
						setFirstRowZeros = true;
						break;
					}
				}
				for(int y = 1; y < matrix.length; y ++) {
					for(int x = 1; x < matrix[0].length; x ++) {
						if(matrix[y][x] == 0) {
							System.out.println("(y, x) = (" + y + ", " + x + ")");
							matrix[y][0] = 0;
							matrix[0][x] = 0;
						}
					}
				}
				for(int y = 0; y < matrix.length; y++) {
					if(matrix[y][0] == 0) {
						for(int x = 1; x < matrix[0].length; x ++) {
							matrix[y][x] = 0;
						}
					}
				}
				for(int x = 0; x < matrix[0].length; x++) {
					if(matrix[0][x] == 0) {
						for(int y = 1; y < matrix.length; y ++) {
							matrix[y][x] = 0;
						}
					}
				}
				if(setFirstColZeros) {
					for(int y = 0; y < matrix.length; y ++) {
						matrix[y][0] = 0;
					}
				}
				if(setFirstRowZeros) {
					for(int x = 0; x < matrix[0].length; x ++) {
						matrix[0][x] = 0;
					}
				}
			}
		}
	}

}
