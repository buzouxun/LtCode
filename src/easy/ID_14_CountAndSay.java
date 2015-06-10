package easy;

public class ID_14_CountAndSay {

	public static void main(String[] args) {
		ID_14_CountAndSay problem = new ID_14_CountAndSay();

		System.out.println("n = 3, nth = " + problem.new Solution().countAndSay(4));

	}

	class Solution {
		public String countAndSay(int n) {
			String say = "1";
			for(int i = 0; i < n - 1; i ++) {
				say = countAndSayHelper(say);
			}			
			return say;
		}

		private String countAndSayHelper(String number) {
			int length = number.length();
			char digit = 'a';
			int occur = 0;
			String say = "";
			while(length > 0) {
				if(digit == 'a') {
					digit = number.charAt(0);
					number = number.substring(1, length);
					occur ++;
					length --;
				}
				else {
					if(digit == number.charAt(0)) {
						number = number.substring(1, length);
						occur ++;
						length --;
					}
					else {
						say += String.valueOf(occur) + String.valueOf(digit);
						digit = 'a';
						occur = 0;
					}					
				}
			}
			if(digit != 'a') {
				say += String.valueOf(occur) + String.valueOf(digit);
				digit = 'a';
				occur = 0;
			}
			return say;
		}
	}

}
