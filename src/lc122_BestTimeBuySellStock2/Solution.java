package lc122_BestTimeBuySellStock2;
/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one
and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = prices[prices.length-1];
        int result = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            if (prices[i] >= max) {
                max = prices[i];
            } else if (i == 0 || prices[i-1] >= prices[i]) {
                result += (max - prices[i]);
                max = prices[i];
            }
        }
        return result;
    }
}