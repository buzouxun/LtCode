package medium;

public class ID_112_BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {

		// [2, 3, 1, 99]

		public int maxProfit(int[] prices) {
			if(prices == null || prices.length == 0) {
				return 0;
			}
			else {
				int min = prices[0];
				int max = prices[0];
				int secMin = prices[0];
				for(int i = 1; i < prices.length; i++) {
					int price = prices[i];
					if(price > max) {
						max = price;
						min = secMin;
					}
					else if(price < secMin) {
						secMin = price;
					}
					else if(price > secMin) {
						if(price - secMin > max - min) {
							max = price;
							min = secMin;
						}
					}
				}			
				return max - min;
			}
		}
	}

}
