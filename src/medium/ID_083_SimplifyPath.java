package medium;

import java.util.LinkedList;
import java.util.List;

public class ID_083_SimplifyPath {

	public static void main(String[] args) {
		ID_083_SimplifyPath problem = new ID_083_SimplifyPath();

		System.out.println("/home/  ->  " + problem.new Solution().simplifyPath("/home/"));
		System.out.println("/a/./b/../../c/  ->  " + problem.new Solution().simplifyPath("/a/./b/../../c/"));
	}

	class Solution {
		public String simplifyPath(String path) {
			String s = "";
			if(path.length() <= 1) {
				s = path;
			}
			else {
				List<String> dirs = new LinkedList<String>();
				// first slash
				if(path.substring(0, 1).equals("/")) {
					dirs.add("/");
				}
				
				for(String tmp : path.split("/")) {
					if(!tmp.equals("")) {
						if(tmp.equals("..")) {
							if(dirs.size() > 1) {
								dirs.remove(dirs.size() - 1);
							}
						}
						else if (tmp.equals(".")) {
							// do nothing
						}
						else {
							dirs.add(String.valueOf(tmp));
						}
					}
				}
				if(dirs.size() > 1) {
					for(int i = 1; i < dirs.size(); i++ ) {
						s += "/" + dirs.get(i);
					}
				}
				else {
					s = "/";
				}
			}
			return s;
		}
	}

}
