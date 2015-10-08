package medium;

import java.util.HashMap;
import java.util.Map;

public class ID_052_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		ID_052_LongestSubstringWithoutRepeatingCharacters problem = new ID_052_LongestSubstringWithoutRepeatingCharacters();

		System.out.println("'abca' = " + problem.new Solution().lengthOfLongestSubstring("abcaaabcc"));
		//		System.out.println("'abcccxyz' = " + problem.new Solution().lengthOfLongestSubstring("abcccxyz"));
		//		System.out.println("'abccbcxyz' = " + problem.new Solution().lengthOfLongestSubstring("abccbcxyz"));

	}
	
	class Solution {		
		
		public int lengthOfLongestSubstring(String s) {
			int maxLength = 0;
			if(s.length() == 0 || s.length() == 1) {
				maxLength = s.length();
			}
			else {
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				int leftPointer = -1;
				for(int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
					char c = s.charAt(rightPointer);
					if(map.containsKey(c)) {
						leftPointer = Math.max(leftPointer, map.get(c));
						System.out.println("char = " + c + ", leftPointer = " + leftPointer);
					}
					else {
						// don't move left pointer
					}
					map.put(c, rightPointer);
					maxLength = Math.max(maxLength, rightPointer - leftPointer);
				}				
			}
			return maxLength;
		}
	}
}
