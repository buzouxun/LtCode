package medium;

import java.util.*;

public class ID_089_WordSearch {

	public static void main(String[] args) {
		ID_089_WordSearch problem = new ID_089_WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		//		System.out.println(problem.new Solution().exist(board, "ABCB"));
		System.out.println(problem.new Solution().exist(board, "SEE"));
	}

	class Solution {
		public boolean exist(char[][] board, String word) {
			boolean[] found = new boolean[]{false};
			if(word == null || word.length() == 0) {
				// do nothing
			}
			else if(board.length == 0 || board[0].length == 0) {
				// do nothing
			}
			else {
				int y = -1;
				int x = -1;
				bt(board, word, new String(), y, x, found);
			}
			return found[0];
		}

		private void bt(char[][] board, String target, String guess, int y, int x, boolean[] found) {
			// reject
			if(found[0]) {
				return;
			}
			if(guess.length() > 0 && guess.length() < target.length() && (!guess.equals(target.substring(0, guess.length())))) {
				return;
			}
			if(guess.length() > target.length()) {
				return;
			}
			// accept
			if(guess.length() == target.length() && guess.equals(target)) {
				found[0] = true;
				return;
			}
			// first
			List<int[]> choices = new ArrayList<int[]>();
			if(y == -1 && x == -1) {
				for(int j = 0; j < board.length; j ++) {
					for(int i = 0; i < board[0].length; i++) {
						if(board[j][i] == target.toCharArray()[0]) {
							choices.add(new int[]{j, i});
						}
					}
				}
				//				System.out.println(choices.toString());
				//				System.out.println(Arrays.toString(choices.get(1)));
			}
			else {
				if(y - 1 >= 0 && board[y - 1][x] != '!') {
					choices.add(new int[]{y - 1, x});
				}
				if(y + 1 < board.length && board[y + 1][x] != '!') {
					choices.add(new int[]{y + 1, x});
				}
				if(x - 1 >= 0 && board[y][x - 1] != '!') {
					choices.add(new int[]{y, x - 1});
				}
				if(x + 1 < board[0].length && board[y][x + 1] != '!') {
					choices.add(new int[]{y, x + 1});
				}
			}
			int i = 0;
			while(i < choices.size()) {
				int new_y = choices.get(i)[0];
				int new_x = choices.get(i)[1];
				String new_guess = guess + String.valueOf(board[new_y][new_x]);
				//				System.out.println("new_guess = " + new_guess);
				//				System.out.println("	new_y = " + new_y);
				//				System.out.println("	new_x = " + new_x);
				char[][]new_board = new char[board.length][board[0].length];
				for(int j = 0; j < board.length; j++) {
					new_board[j] = board[j].clone();
				}
				new_board[new_y][new_x] = '!';
				bt(new_board, target, new_guess, new_y, new_x, found);
				i ++;
			}
		}
	}
}
