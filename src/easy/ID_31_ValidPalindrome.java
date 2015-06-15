package easy;

public class ID_31_ValidPalindrome {

	public static void main(String[] args) {
		ID_31_ValidPalindrome problem = new ID_31_ValidPalindrome();

		System.out.println(problem.new Solution().isPalindrome("a."));


		//		System.out.println("'A' = " + (int)'A' );
		//		System.out.println("'Z' = " + (int)'Z' );
		//		System.out.println("'a' = " + (int)'a' );
		//		System.out.println("'z' = " + (int)'z' );
	}

	class Solution {
		public boolean isPalindrome(String s) {
			s = s.toLowerCase();
			boolean valid = true;
			int length = s.length();
			if(length == 0 || length == 1) {
				valid = true;
			}
			else {
				int head = 0;
				int tail = s.length() - 1;
				while(head != tail && tail - head > 1) {
					char headChar = s.charAt(head);
					char tailChar = s.charAt(tail);
					if(!isLetter(headChar)) {
						head ++;
					}
					else if(!isLetter(tailChar)) {
						tail --;
					}
					else {
						if(headChar == tailChar) {
							head ++;
							tail --;
						}
						else {
							valid = false;
							break;
						}
					}
				}
				if(head != tail && tail - head == 1) {
					char headChar = s.charAt(head);
					char tailChar = s.charAt(tail);
					if(!isLetter(headChar)) {
						// do nothing
					}
					else if(!isLetter(tailChar)) {
						// do nothing
					}
					else {
						if(headChar == tailChar) {
							// do nothing
						}
						else {
							valid = false;
						}
					}
				}
			}
			return valid;
		}
		private boolean isLetter(char c) {
			return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
		}
	}

}
