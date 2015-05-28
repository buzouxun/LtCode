package easy;

public class ID_06_LongestCommonPrefix {

	public static void main(String[] args) {
		ID_06_LongestCommonPrefix problem = new ID_06_LongestCommonPrefix();
		String test = "";

		// ["aab", "aac"] -> "aa"
		//		test = problem.new Solution().longestCommonPrefix(new String[]{"aab", "aac"});
		//		System.out.println("['aab', 'aac'] -> 'aa' = " + test);

		// ["aa", "a"] -> "a"
		test = problem.new Solution().longestCommonPrefix(new String[]{"aa", "a"});
		System.out.println("['aa', 'a'] -> 'a' = " + test);

	}

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			String sol = "";
			int charIndex = 0;
			boolean notFound = true;
			while(notFound) {
				if(strs.length == 0) {
					notFound = false;
				}
				for(String str : strs) {
					if(sol.length() < charIndex + 1) {
						if(str.length() > charIndex) {
							sol = new StringBuilder(sol).append(str.charAt(charIndex)).toString();
						}
						else {
							notFound = false;
							break;
						}
					}
					else {
						if(str.length() < charIndex + 1 || sol.charAt(charIndex) != str.charAt(charIndex)) {
							sol = sol.substring(0, sol.length()-1);
							notFound = false;
							break;
						}
					}
				}
				charIndex ++;
			}			
			return sol;
		}

	}
}