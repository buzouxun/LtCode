package medium;

public class ID_055_IntegerToRoman {

	public static void main(String[] args) {
		ID_055_IntegerToRoman problem = new ID_055_IntegerToRoman();
		System.out.println("1990 as " + problem.new Solution().intToRoman(1990));

	}

	class Solution {
		public String intToRoman(int num) {
			String roman = "";
			String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};
			int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
			int i = 0;
			while(num != 0) {
				if(num >= values[i]) {
					roman += symbols[i];
					num -= values[i];
				}
				else {
					i ++;
				}
			}			
			return roman;
		}
	}

}
