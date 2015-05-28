package easy;

public class ID_01_ZigZagConversion {

	/*
	 * define Zigzag pattern
	 * 
	 * X       X    X
	 * X     X X   X
	 * X   X   X  X
	 * X X     X X
	 * X       X
	 * 
	 * 1     9          17
	 * 2   8 10      16 18
	 * 3  7  11    15   19 
	 * 4 6   12  14     20
	 * 5     13
	 * 
	 */

	public static void main(String[] args) {
		ID_01_ZigZagConversion problem = new ID_01_ZigZagConversion();
		String test = "";
		// ABC, 1 -> ABC
		test = problem.new Solution().convert("ABC", 1);
		System.out.println("ABC = " + test);

		// ABC, 2 -> ACB
		test = problem.new Solution().convert("ABC", 2);
		System.out.println("ACB = " + test);

		// ABCDEFG, 4 -> AGBFCED
		test = problem.new Solution().convert("ABCDEFG", 4);
		System.out.println("AGBFCED = " + test);

		// PAYPALISHIRING, 3 -> PAHNAPLSIIGYIR
		test = problem.new Solution().convert("PAYPALISHIRING", 3);
		System.out.println("PAHNAPLSIIGYIR = " + test);		

	}

	class Solution {
		public String convert(String s, int numRows) {
			String sol = "";
			int sLength = s.length();
			int arcLength = 2 * numRows - 2;
			if (numRows == 1) {
				arcLength = 1;
			}
			int num_arcs = (int) Math.ceil( (double) sLength / arcLength);
			// traverse
			for(int rowId = 0; rowId < numRows; rowId++) {
				for(int arcId = 0; arcId < num_arcs; arcId++) {
					int index = arcId * arcLength + rowId;
					if(index >= sLength) {
						break;
					}
					sol += String.valueOf(s.charAt(index));
					if (rowId > 0 && rowId < numRows - 1) {
						int index_2 = arcId * arcLength + (arcLength - rowId);
						if(index_2 < sLength){
							sol += String.valueOf(s.charAt(index_2));
						}
					}
				}				
			}			
			return sol;
		}
	}

}
