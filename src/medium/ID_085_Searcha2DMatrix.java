package medium;

public class ID_085_Searcha2DMatrix {

	public static void main(String[] args) {
		ID_085_Searcha2DMatrix problem = new ID_085_Searcha2DMatrix();

		System.out.println(problem.new Solution().searchMatrix(new int[][]{{0}, {5}, {6}, {7}, {10}},  5));
	}

	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			boolean res = false;
			if (matrix.length == 0 || matrix[0].length == 0) {
				res = false;
			}
			else if(matrix.length == 1) {
				res = helper(matrix[0], target);
			}
			else {
				int head = 0;
				int tail = matrix.length - 1;
				int guess = (int) Math.floor((head + tail) / 2);
				while(tail - head > 1) {
					if(matrix[guess][0] < target) {
						head = guess;
						guess = (int) Math.floor((head + tail) / 2);
					}
					else if(matrix[guess][0] > target) {
						tail = guess;
						guess = (int) Math.floor((head + tail) / 2);
					}
					else {
						res = true;
						break;
					}
				}
				if(res == false) {
					if(target >= matrix[tail][0]) {
						res = helper(matrix[tail], target);
					}
					else {
						res = helper(matrix[head], target);
					}
				}
			}
			return res;
		}
		
		private boolean helper(int[] array, int target) {
			boolean res = false;
			System.out.println("helper: array[0] = " + array[0]);
			int head = 0;
			int tail = array.length - 1;
			int guess = (int) Math.floor((head + tail) / 2);
			while(tail - head > 1) {
				if(array[guess] < target) {
					head = guess;
					guess = (int) Math.floor((head + tail) / 2);
				}
				else if(array[guess] > target) {
					tail = guess;
					guess = (int) Math.floor((head + tail) / 2);
				}
				else {
					res = true;
					break;
				}
			}
			if(res == false) {
				res = array[head] == target || array[tail] == target;
			}
			return res;
		}
	}

}
