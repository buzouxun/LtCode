package medium;

public class ID_070_RotateImage {

	public static void main(String[] args) {
		ID_070_RotateImage problem = new ID_070_RotateImage();
		int[][] test = null;
		
		// [[1,2],[3,4]] -> [[3,1],[4,2]]
		test = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
		problem.new Solution().rotate(test);
		System.out.println("[[1,2],[3,4]] -> "); 
		
	}

	class Solution {
		
		// 1, 2   =  3,1
		// 3, 4      4,2 
		
		public void rotate(int[][] matrix) {
			int tmp = -1;
			int length = matrix.length;
			float mid = ((float)length) / 2;
			for(int y = 0; y < length; y ++) {
				for(int x = 0; x < mid; x ++) {
					tmp = matrix[y][x];
					matrix[y][x] = matrix[y][length - 1 - x];
					matrix[y][length - 1 - x] = tmp;
				}
			}
			for(int y = 0; y < length; y ++) {
				int diagonal = length - 1 - y;
				for(int x = 0; x < diagonal; x ++) {
					tmp = matrix[y][x];
					matrix[y][x] = matrix[length - 1 - x][length - 1 - y];
					matrix[length - 1 - x][length - 1 - y] = tmp;
				}
			}			
		}
	}

}
