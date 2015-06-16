package easy;

public class ID_36_ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ID_36_ExcelSheetColumnTitle problem = new ID_36_ExcelSheetColumnTitle();

		System.out.println("1 -> A = " + problem.new Solution().convertToTitle(1));
		System.out.println("26 -> Z = " + problem.new Solution().convertToTitle(26));
		System.out.println("27 -> AA = " + problem.new Solution().convertToTitle(27));
		System.out.println("52 -> AZ = " + problem.new Solution().convertToTitle(52));
		System.out.println("59 -> BG = " + problem.new Solution().convertToTitle(59));

	}

	// 1 -> A   
	// 26 -> Z  
	// 27 -> AA
	// 29 -> AC

	// 0 -> A
	// 25 -> Z
	// 26 -> AA
	// 28 -> AC

	class Solution {
		public String convertToTitle(int n) {
			String title = "";
			while(n > 0) {
				n --;
				int reminder = n % 26;
				title = String.valueOf( (char) (reminder + 'A')) + title;
				n = n / 26;
			}
			return title;		
			// Junyu's naive
			/*
			String title = "";
			if(n <= 0) {
				// do nothing
			}
			else {
				boolean loop = true;
				while(loop) {
					int tmp = n;
					int reminder = 0;
					int count = 0;
					while(tmp > 26) {
						reminder = tmp % 26;
						tmp /= 26;
						if(reminder == 0 && tmp > 1) {
							tmp --;
						}
						count ++;
					}
					if(tmp == n) {
						loop = false;
					}
					title += String.valueOf( (char) (tmp - 1 + 'A'));
					if(count != 0) {
						n -= ((int) Math.pow(26, count)) * tmp;
					}
				}
			}
			return title;
			 */
		}
	}

}