package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_13_ValidSudoku {

	public static void main(String[] args) {
		ID_13_ValidSudoku problem = new ID_13_ValidSudoku();
		boolean test = true;

		char[][] board = new char[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 && j == 0) {
					board[i][j] = '.';
				} else if (i == 0 && j != 0) {
					board[i][j] = (char)('0' + j + 1);
				} else {
					board[i][j] = '.';
				}
			}
		}
		System.out.println("isValidSudoku = " + problem.new Solution().isValidSudoku(board));

	}

	class Solution {
		public boolean isValidSudoku(char[][] board) {
			boolean valid = true;
			int[][] rows = new int[9][9];
			int[][] cols = new int[9][9];
			int[][] squs = new int[9][9];
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					int rowKey = i;					
					int columnKey = j;
					int squareKey = (i / 3) * 3 + j / 3;
					if(board[i][j] != '.') {
						int number = board[i][j] - '0' - 1;
						// check row
						if(rows[rowKey][number] == 1) {
							valid = false;
							break;
						}
						else {
							rows[rowKey][number] = 1;
						}
						// check column
						if(cols[columnKey][number] == 1) {
							valid = false;
							break;
						}
						else {
							cols[columnKey][number] = 1;
						}
						// check square
						if(squs[squareKey][number] == 1) {
							valid = false;
							break;
						}
						else {
							squs[squareKey][number] = 1;
						}
					}
				}
				if(!valid) {
					break;
				}
			}
			return valid;
			
			// HashMap between row_id_number, column_id
			/*
			boolean valid = true;
			Map<String , Integer> rows = new HashMap<String, Integer>();
			Map<String , Integer> columns = new HashMap<String, Integer>();
			Map<String , Integer> squares = new HashMap<String, Integer>();
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					int rowKey = i;					
					int columnKey = j;
					int squareKey = (i / 3) * 3 + j / 3;
					String key = "";
					if(board[i][j] != '.') {
						int number = board[i][j] - '0';
						// check row
						key = "row_" + rowKey + "_" + number;
						if(rows.containsKey(key)) {
							valid = false;
							break;
						}
						else {
							rows.put(key, number);
						}
						// check column
						key = "col_" + columnKey + "_" + number;
						if(columns.containsKey(key)) {
							valid = false;
							break;
						}
						else {
							columns.put(key, number);
						}
						// check square
						key = "squ_" + squareKey + "_" + number;
						if(squares.containsKey(key)) {
							valid = false;
							break;
						}
						else {
							squares.put(key, number);
						}
					}
				}
				if(!valid) {
					break;
				}
			}
			return valid;
			 */
		}
	}
}
