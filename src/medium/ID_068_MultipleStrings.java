package medium;

public class ID_068_MultipleStrings {

	public static void main(String[] args) {
		ID_068_MultipleStrings problem = new ID_068_MultipleStrings();

		//		System.out.println("123 * 1 = " + problem.new Solution().multiply("123", "1"));
		//		System.out.println("99 * 99 = " + problem.new Solution().multiply("99", "99"));
		//		System.out.println("9596476860182918375588249918 * 386874243223318346831422661 = " + problem.new Solution().multiply("9596476860182918375588249918", "386874243223318346831422661"));
		//		System.out.println("821153331930095826177565783278150486711 * 2612682063730597442325050837160321781998 = " + problem.new Solution().multiply("821153331930095826177565783278150486711", "2612682063730597442325050837160321781998"));

	}

	class Solution {
		public String multiply(String num1, String num2) {
			String res_string = "";
			if(num1.length() == 0 || num2.length() == 0) {
				// do nothing;
			}
			else if (num1.equals("0") || num2.equals("0")) {
				res_string = "0";
			}
			else {
				char[] c1 = num1.toCharArray();
				char[] c2 = num2.toCharArray();
				char[] longer = c1.length > c2.length ? c1 : c2;
				char[] shorter = c1.length <= c2.length ? c1 : c2;
				int longer_l = longer.length;
				int shorter_l = shorter.length;
				int[] res = new int[longer_l + shorter_l];
				for(int i = shorter_l - 1; i >=0; i --) {
					for(int j = longer_l - 1; j >= 0; j --) {
						int num_i = shorter[i] - '0';
						int num_j = longer[j] - '0';
						int index = (shorter_l - 1 - i) + (longer_l - 1 - j);
						int multiply = num_i * num_j;
						res[index] += multiply;
						if(index + 1 < res.length) {
							res[index + 1] += res[index] / 10;
						}
						res[index] %= 10;
					}
				}
				boolean firstNonZeroNumberFound = false;
				StringBuilder ans = new StringBuilder();
				for(int k = res.length - 1; k >= 0; k--) {
					if(firstNonZeroNumberFound == false && res[k] != 0) {
						firstNonZeroNumberFound = true;
						// res_string += String.valueOf(res[k]);
						ans.append(res[k]);
					}
					else if(firstNonZeroNumberFound){
						// res_string += String.valueOf(res[k]);
						ans.append(res[k]);						
					}
				}
				res_string = ans.toString();
			}
			return res_string;
		}
	}
}