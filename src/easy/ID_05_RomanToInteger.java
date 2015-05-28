package easy;

import easy.ID_04_PalindromeNumber.Solution;

public class ID_05_RomanToInteger {

	public static void main(String[] args) {
		ID_05_RomanToInteger problem = new ID_05_RomanToInteger();
		int test = -1;

		// I -> 1
		test = problem.new Solution().romanToInt("I");
		System.out.println("I -> 1 = " + test);

		// IX -> 9
		test = problem.new Solution().romanToInt("IX");
		System.out.println("IX -> 9 = " + test);

	}

	class Solution {

		/*
			Symbol	Value			
			I	1 
			V	5 
			X	10 
			L	50 
			C	100 
			D	500 
			M	1,000 

			- the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
			- X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
			- C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
		 */

		public int romanToInt(String s) {
			int sol = 0;
			char[] romanChars = s.toCharArray();
			int romanCharIndex = 0;
			while(romanCharIndex < romanChars.length) {
				char firstRomanChar = romanChars[romanCharIndex];
				if(firstRomanChar == 'I') {
					if(romanCharIndex < romanChars.length - 1) {
						char secondRomanChar = romanChars[romanCharIndex + 1];
						if(secondRomanChar == 'V') {
							sol += 4;
							romanCharIndex += 2;
						}
						else if(secondRomanChar == 'X') {
							sol += 9;
							romanCharIndex += 2;
						}
						else {
							sol += 1;
							romanCharIndex += 1;
						}
					}
					else {
						sol += 1;
						romanCharIndex += 1;
					}
				}
				else if(firstRomanChar == 'V') {
					sol += 5;
					romanCharIndex += 1;
				}
				else if(firstRomanChar == 'X') {
					if(romanCharIndex < romanChars.length - 1) {
						char secondRomanChar = romanChars[romanCharIndex + 1];
						if(secondRomanChar == 'L') {
							sol += 40;
							romanCharIndex += 2;
						}
						else if(secondRomanChar == 'C') {
							sol += 90;
							romanCharIndex += 2;
						}
						else {
							sol += 10;
							romanCharIndex += 1;
						}
					}
					else {
						sol += 10;
						romanCharIndex += 1;
					}
				}
				else if(firstRomanChar == 'L') {
					sol += 50;
					romanCharIndex += 1;
				}
				else if(firstRomanChar == 'C') {
					if(romanCharIndex < romanChars.length - 1) {
						char secondRomanChar = romanChars[romanCharIndex + 1];
						if(secondRomanChar == 'D') {
							sol += 400;
							romanCharIndex += 2;
						}
						else if(secondRomanChar == 'M') {
							sol += 900;
							romanCharIndex += 2;
						}
						else {
							sol += 100;
							romanCharIndex += 1;
						}
					}
					else {
						sol += 100;
						romanCharIndex += 1;
					}
				}
				else if(firstRomanChar == 'D') {
					sol += 500;
					romanCharIndex += 1;
				}
				else if(firstRomanChar == 'M') {
					sol += 1000;
					romanCharIndex += 1;
				}				
			}
			return sol;
		}
	}

}
