package easy;

public class ID_39_ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//	   A ->  1
	//	   B ->  2
	//	   C ->  3
	//	   Z ->  26
	//	   AA -> 27
	//	   AB -> 28 

	class Solution {
		public int titleToNumber(String s) {
			int number = 0;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int decimal = c - 'A' + 1;
				number = number * 26 + decimal;
			}
			return number;
		}
	}

}
