package medium;

import java.util.*;

public class ID_116_SurroundedRegions {

	public static void main(String[] args) {
		ID_116_SurroundedRegions problem = new ID_116_SurroundedRegions();
		char[][] test = new char[][]{{'X','X','X'}, {'X','O','X'}, {'X','X','X'}};
		problem.new Solution().solve(test);
		System.out.println();
	}

	class Solution {
		public void solve(char[][] board) {
			if(board.length <= 2 || board[0].length <= 2 || board == null) {
				// do nothing
			}
			else {
				boolean[][] bb = new boolean[board.length][board[0].length];
				int i = 0;
				int j = 0;
				// top
				for(i = 1; i < board[0].length - 1; i++) {
					if(board[0][i] == 'O') {
						bb[0][i] = true;
						bb[1][i] = true;						
					}
				}
				// bottom
				for(i = 1; i < board[board.length - 1].length - 1; i++) {
					if(board[board.length - 1][i] == 'O') {
						bb[board.length - 1][i] = true;
						bb[board.length - 2][i] = true;						
					}
				}
				// left
				for(j = 1; j < board.length - 1; j++) {
					if(board[j][0] == 'O') {
						bb[j][0] = true;
						bb[j][1] = true;
					}
				}
				// right
				for(j = 1; j < board.length - 1; j++) {
					if(board[j][board[0].length - 1] == 'O') {
						bb[j][board[0].length - 1] = true;
						bb[j][board[0].length - 2] = true;
					}
				}
				// loop
				Queue<Integer> qi = new LinkedList<Integer>();
				Queue<Integer> qj = new LinkedList<Integer>();
				Queue<Integer> qii = new LinkedList<Integer>();
				Queue<Integer> qjj = new LinkedList<Integer>();
				for(j = 1; j < board.length - 1; j++) {
					for(i = 1; i < board[0].length - 1; i++) {
						if(board[j][i] == 'O') {
							if(bb[j][i] == true) {
								qi.add(i);
								qj.add(j);
							}
							qii.add(i);
							qjj.add(j);
						}
					}
				}
				while((!qi.isEmpty()) && (!qj.isEmpty())) {
					int size = qi.size();
					for(int k = 0; k < size; k++) {
						int ti = qi.poll();
						int tj = qj.poll();
						// top 
						if(board[tj - 1][ti] == 'O' && bb[tj - 1][ti] == false) {
							bb[tj - 1][ti] = true;
							qi.add(ti);
							qj.add(tj - 1);
						}
						// bottom
						if(board[tj + 1][ti] == 'O' && bb[tj + 1][ti] == false) {
							bb[tj + 1][ti] = true;
							qi.add(ti);
							qj.add(tj + 1);
						}
						// left
						if(board[tj][ti - 1] == 'O' && bb[tj][ti - 1] == false) {
							bb[tj][ti - 1] = true;
							qi.add(ti - 1);
							qj.add(tj);
						}
						// right
						if(board[tj][ti + 1] == 'O' && bb[tj][ti + 1] == false) {
							bb[tj][ti + 1] = true;
							qi.add(ti + 1);
							qj.add(tj);
						}
					}
				}
				// revert to X
				while((!qii.isEmpty()) && (!qjj.isEmpty())) {
					int tii = qii.poll();
					int tjj = qjj.poll();
					if(bb[tjj][tii] == false) {
						board[tjj][tii] = 'X';
					}
				}
			}
			
		}
	}

}
