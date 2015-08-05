package medium;

public class ID_053_LongestPalindromicSubstring {

	public static void main(String[] args) {
		ID_053_LongestPalindromicSubstring problem = new ID_053_LongestPalindromicSubstring();

		System.out.println("madam = " + problem.new Solution().longestPalindrome("madam"));

	}

	class Solution {
		public String longestPalindrome(String s) {
			String longestPalidrom = "";
			int length = s.length();
			if(length == 0 || length == 1) {
				longestPalidrom = s;
			}
			else {
				for(int i = 0; i < length - 1; i++) {
					String newParlidrom = findPalidrome(s, i, i);
					if(newParlidrom.length() > longestPalidrom.length()) {
						longestPalidrom = newParlidrom;
					}
					newParlidrom = findPalidrome(s, i, i + 1);
					if(newParlidrom.length() > longestPalidrom.length()) {
						longestPalidrom = newParlidrom;
					}
				}
			}			
			return longestPalidrom;
		}

		private String findPalidrome(String s, int left, int right) {
			String palidrom = "";
			if(s.charAt(left) != s.charAt(right)) {
				// terminate
			}
			else {
				left --;
				right ++;
				while(left >=0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
					left --;
					right ++;
				}
				if(right - left >= 1) {
					palidrom = s.substring(left + 1, right);
				}
			}
			return palidrom;
		}

	}

}
