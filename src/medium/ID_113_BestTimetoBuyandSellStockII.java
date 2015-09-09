package medium;

public class ID_113_BestTimetoBuyandSellStockII {

	public static void main(String[] args) {

	}

	class Solution {
		public int maxProfit(int[] prices) {
			int profit = 0;
			if(prices == null || prices.length == 0 ) {

			}
			else {
				int buy = prices[0];
				int sell = prices[0];
				for(int i = 1; i < prices.length; i++) {
					int price = prices[i];
					if(price > buy) {
						if(price > sell) {
							sell = prices[i];
						}
						else if(price < sell) {
							profit += sell - buy;
							buy = price;
							sell = price;
						}
					}
					else {
						profit += sell - buy;
						buy = price;
						sell = price;
					}
				}
				profit += sell - buy;
			}
			return profit;
		}
	}

}
