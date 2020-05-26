package lc121_BestBuySellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        if (prices.length > 0) {
            int max = prices[prices.length-1];
            for (int i = prices.length - 2; i >= 0; i--) {
                if (prices[i] > max) {
                    max = prices[i];
                } else {
                    if (max - prices[i] > best) {
                        best = max - prices[i];
                    }
                }
            }
        }
        return best;
    }
}