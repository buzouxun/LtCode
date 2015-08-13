package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ID_071_GroupAnagrams {

	public static void main(String[] args) {
		ID_071_GroupAnagrams problem = new ID_071_GroupAnagrams();
		
		// ["eat", "tea", "tan", "ate", "nat", "bat"] -> [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]		
		System.out.println("" + problem.new Solution().groupAnagrams(new String[]{"tan", "nat", "ate", "eat","tea", "bat"}));

	}
	
	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	List<List<String>> groups = new ArrayList<List<String>>();
	    	Map<String, List<String>> map = new HashMap<String, List<String>>();
	    	for(int i = 0; i < strs.length; i++) {
	    		String s = strs[i];
	    		char[] chars = s.toCharArray();
	    		Arrays.sort(chars);
	    		String key = new String(chars);
	    		if(map.containsKey(key)) {
	    			List<String> value = map.get(key);
	    			value.add(s);
	    		}
	    		else {
	    			List<String> newValue = new ArrayList<String>();
	    			newValue.add(s);
	    			map.put(key, newValue);
	    		}
	    	}
	    	for (List<String> listAnagrams : map.values()) {
				String[] array = listAnagrams.toArray(new String[listAnagrams.size()]);
	    		Arrays.sort(array);
	    		groups.add(Arrays.asList(array));
			}
	    	return groups;
	    }
	}

}
