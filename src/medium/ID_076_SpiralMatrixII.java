package medium;

public class ID_076_SpiralMatrixII {

	public static void main(String[] args) {
		ID_076_SpiralMatrixII problem = new ID_076_SpiralMatrixII();
		int[][] test = null;
		// n = 3 -> [[ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ]]
		test = problem.new Solution().generateMatrix(1);
		System.out.println("");
	}

	class Solution {
		public int[][] generateMatrix(int n) {
			if(n <= 0) {
				return new int[0][0];
			}
			int[][] matrix = new int[n][n];
			int i = 0;
			int j = 0;
			int num = 1;
			int iMin = 0;
			int iMax = n - 1;
			int jMin = 0;
			int jMax = n - 1;
			while(iMin <= iMax && jMin <= jMax) {
				for(i = iMin; i <= iMax; i++) {
					matrix[jMin][i] = num;
					num ++;
				}
				jMin ++;
				for(j = jMin; j <= jMax; j++) {
					matrix[j][iMax] = num;
					num ++;
				}
				iMax --;
				for(i = iMax; i >= iMin; i--) {
					matrix[jMax][i] = num;
					num ++;
				}
				jMax --;
				for(j = jMax; j >= jMin; j--) {
					matrix[j][iMin] = num;
					num ++;
				}
				iMin ++ ;
			}			
			return matrix;
		}
	}

}
