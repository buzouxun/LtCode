package medium;

import java.util.ArrayList;
import java.util.List;

public class ID_074_SpiralMatrix {

	public static void main(String[] args) {
		ID_074_SpiralMatrix problem = new ID_074_SpiralMatrix();
		
//		System.out.println("" + problem.new Solution().spiralOrder(new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }));
		System.out.println("" + problem.new Solution().spiralOrder(new int[][]{ {2, 3} }));

	}

	class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			List<Integer> order = new ArrayList<Integer> ();
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
			int i = 0;
			int j = 0;
			int iMin = 0;
			int iMax = matrix[0].length - 1;
			int jMin = 0;
			int jMax = matrix.length - 1;
			while(iMin <= iMax && jMin <= jMax) {
				for(i = iMin; i <= iMax; i++) {
					order.add(Integer.valueOf(matrix[jMin][i]));
				}
				jMin ++;
				if(jMin > jMax) break;
				for(j = jMin; j <= jMax; j++) {
					order.add(Integer.valueOf(matrix[j][iMax]));
				}
				iMax --;
				if(iMin > iMax) break;
				for(i = iMax; i >= iMin; i--) {
					order.add(Integer.valueOf(matrix[jMax][i]));
				}
				jMax --;
				if(jMin > jMax) break;
				for(j = jMax; j >= jMin; j--) {
					order.add(Integer.valueOf(matrix[j][iMin]));
				}
				iMin ++;
				if(iMin > iMax) break;
			}
			return order;
		}
	}

}
