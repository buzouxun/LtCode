package easy;

public class ID_35_CompareVersionNumbers {

	public static void main(String[] args) {
		ID_35_CompareVersionNumbers problem = new ID_35_CompareVersionNumbers();
		
		System.out.println(" '1.0', '1' = " + problem.new Solution().compareVersion("1.0", "1"));

	}

	class Solution {
		public int compareVersion(String version1, String version2) {
			// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
			int result = 0;
			String[] ver1List = (version1 + ".0").split("\\.");
			String[] ver2List = (version2 + ".0").split("\\.");
			int shorterListLength = 0;
			if(ver1List.length > ver2List.length) {
				shorterListLength = ver2List.length;
			}
			else {
				shorterListLength = ver1List.length;
			}
			for(int i = 0; i < shorterListLength; i++) {
				int ver1 = Integer.valueOf(ver1List[i]);
				int ver2 = Integer.valueOf(ver2List[i]);
				if(ver1 < ver2) {
					result = -1;
					break;
				}
				else if(ver1 > ver2) {
					result = 1;
					break;
				}
				else {
					// do nothing
				}
			}
			if(result == 0) {
				if(ver1List.length > ver2List.length) {
					int diff = ver1List.length - ver2List.length;
					for(int i = 0; i < diff; i++) {
						int ver1 = Integer.valueOf(ver1List[i + ver2List.length]);
						if(ver1 > 0) {
							result = 1;
							break;
						}
					}
				}
				else if(ver1List.length < ver2List.length){
					int diff = ver2List.length - ver1List.length;
					for(int i = 0; i < diff; i++) {
						int ver2 = Integer.valueOf(ver2List[i + ver1List.length]);
						if(ver2 > 0) {
							result = -1;
							break;
						}
					}
				}
			}
			return result;
		}
	}

}
