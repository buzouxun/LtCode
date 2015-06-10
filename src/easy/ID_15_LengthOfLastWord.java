package easy;

public class ID_15_LengthOfLastWord {

	public static void main(String[] args) {
		ID_15_LengthOfLastWord problem = new ID_15_LengthOfLastWord();

		String a = " ";
		String b = "Hello World";
		String c = "           ";
		String d = "a";
		System.out.println(problem.new Solution().lengthOfLastWord(a));
		System.out.println(problem.new Solution().lengthOfLastWord(b));
		System.out.println(problem.new Solution().lengthOfLastWord(c));
		System.out.println(problem.new Solution().lengthOfLastWord(d));

	}

	class Solution {
		public int lengthOfLastWord(String s) {
			int length = 0;
			boolean spaceFound = false;
			boolean charFound = false;
			for(int i = s.length() - 1; i > -1; i --) {
				char c = s.charAt(i);
				if(c == ' ' && !spaceFound && !charFound) {
					// do nothing
				}
				else if(c != ' ' && !spaceFound && !charFound) {
					// find first non-space character
					charFound = true;
					length ++;
				}
				else if(c != ' ' && !spaceFound && charFound) {
					// count more characters
					length ++;
				}
				else if(c == ' ' && !spaceFound && charFound) {
					spaceFound = true;
					break;
				}
			}
			return length;
		}
	}
}
