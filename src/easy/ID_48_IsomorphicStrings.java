package easy;

import java.util.HashMap;
import java.util.Map;

public class ID_48_IsomorphicStrings {

	public static void main(String[] args) {
		ID_48_IsomorphicStrings problem = new ID_48_IsomorphicStrings();

		System.out.println("isIsomorphic('egg', 'add') = " + problem.new Solution().isIsomorphic("egg", "add"));

	}

	class Solution {
		public boolean isIsomorphic(String s, String t) {
			boolean res = true;
			Map<Character, Character> cache = new HashMap();
			char[] sChars = s.toCharArray();
			char[] tChars = t.toCharArray();
			for(int i = 0; i < sChars.length; i++) {
				char c = sChars[i];
				if(cache.containsKey(c)) {
					char valueChar = cache.get(c);
					if(valueChar != tChars[i]) {
						res = false;
						break;
					}
				}
				else {
					if(cache.containsValue(tChars[i])) {
						res = false;
						break;
					}
					else {
						cache.put(c, tChars[i]);
					}
				}
			}
			return res;
		}
	}

}
