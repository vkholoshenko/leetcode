package lc123_BestTimeBuySellStock3;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).


 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[] best1 = new int[prices.length];
        int[] best2 = new int[prices.length];
        if (prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            best1[i] = Math.max(best1[i-1], prices[i] - min);
            if (prices[i] < min) min = prices[i];
        }
        int max = prices[prices.length-1];
        for (int i = prices.length-2; i > 0; i--) {
            best2[i] = Math.max(best2[i+1], max - prices[i]);
            if (prices[i] > max) max = prices[i];
        }

        int best = 0;
        for (int i = 1; i < prices.length; i++) {
            best = Math.max(best, best1[i-1] + best2[i]);
        }
        return Math.max(best, best1[prices.length-1]);
    }
}