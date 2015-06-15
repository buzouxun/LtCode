package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ID_30_PascalsTriangle_II {

	public static void main(String[] args) {
		ID_30_PascalsTriangle_II problem = new ID_30_PascalsTriangle_II();

		int k = 2;
		System.out.println(problem.new Solution().getRow(k).toString());

	}

	class Solution {
		public List<Integer> getRow(int rowIndex) {
			List<Integer> row = new ArrayList<Integer> (Collections.nCopies((rowIndex + 1), 0));
			if(rowIndex == 0) {
				row.set(0, 1);
			}
			else if(rowIndex == 1) {
				row.set(0, 1);
				row.set(1, 1);
			}
			else if(rowIndex >= 2) {
				row.set(0, 1);
				row.set(1, 1);
				// 1, 1, 0, 0, 0 | rowIndex = 1
				// 1, 2, 1, 0, 0 | rowIndex = 2
				// 1, 3, 3, 1, 0 | rowIndex = 3
				for(int i = 2; i <= rowIndex; i++) {
					for(int j = rowIndex; j >= 1; j--) {
						row.set(j, row.get(j - 1) + row.get(j));
					}
				}
			}
			return row;
		}
	}

}
