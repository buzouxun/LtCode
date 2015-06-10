package easy;

public class ID_12_ImplementStrStr {

	public static void main(String[] args) {
		ID_12_ImplementStrStr problem = new ID_12_ImplementStrStr();
		int test = -1;

		test = problem.new Solution().strStr("mississippi", "issip");
		System.out.println("mississippi, issip -> " + test);

	}

	class Solution {
		public int strStr(String haystack, String needle) {
			int index = -1;
			int i_hstck = 0;
			int j_ndl = 0;
			if(needle.length() == 0) {
				index = 0;
			}
			else if(haystack.length() == 0) {
				index = -1;
			}
			else {
				for(i_hstck = 0; i_hstck < haystack.length(); i_hstck ++) {
					if(haystack.charAt(i_hstck) != needle.charAt(0)) {
						// do nothing
					}
					else {
						while(j_ndl < needle.length() && i_hstck < haystack.length()) {
							if(haystack.charAt(i_hstck) == needle.charAt(j_ndl)) {
								i_hstck ++;
								j_ndl ++;
							}
							else {
								i_hstck -= j_ndl;
								j_ndl = 0;
								break;
							}
						}
						if(j_ndl == needle.length()) {
							index = i_hstck - 1 - (j_ndl - 1);
							break;
						}
					}
				}
			}
			return index;

			/*
			// old code
			int h_len = haystack.length();
	        int n_len = needle.length();
	        int h = 0;
	        int n = 0;
	        //int h_offSet = 0;
	        int n_offSet = 0;
	        char h_char = 0;
	        char n_char = 0;

	        for(h = 0; h < h_len; h += 1) {
	            h_char = haystack.charAt(h);

	            for(n = 0; n < n_len; n += n_offSet) {
	                n_char = needle.charAt(n);

	                if(h_char == n_char) {
	                    n_offSet = 1;
	                }
	                else {
	                    n_offSet = 0;
	                    break;
	                }
	            }

	            if(n == n_len) {
	                return h;
	            }
	            else {
	                n = 0;
	                // h_offSet = 1;
	            }
	        }
	        return -1;
			 */
		}
	}

}
