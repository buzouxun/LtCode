package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID_29_PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<Integer> firstRow = Arrays.asList(new Integer[]{1});
			List<Integer> secondRow = Arrays.asList(new Integer[]{1, 1});
			List<List<Integer>> triangle = new ArrayList<List<Integer>>();
			if(numRows >= 1) {
				triangle.add(firstRow);
			}
			if(numRows >= 2) {
				triangle.add(secondRow);
			}
			if(numRows >= 3) {
				while(numRows - 2 > 0) {
					triangle.add(generateNextRow(triangle.get(triangle.size() - 1)));
					numRows --;
				}
			}			
			return triangle;
		}		
		private List<Integer> generateNextRow(List<Integer> row) {
			List<Integer> nextRow = new ArrayList<Integer>();
			nextRow.add(1);
			for(int i = 0; i < row.size() - 1; i++) {
				nextRow.add(row.get(i) + row.get(i + 1));
			}
			nextRow.add(1);
			return nextRow;
		}
	}

}
