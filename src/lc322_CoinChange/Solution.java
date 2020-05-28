package lc322_CoinChange;
/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.


 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        HashMap<Integer, Integer> got = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int coin : coins) {
            got.put(coin, 1);
            q.add(coin);
        }
        if (got.containsKey(amount)) {
            return 1;
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int coin : coins) {
                int next = current + coin;
                if (next == amount) {
                    return  got.get(current) + 1;
                }
                if (!got.containsKey(next) && next < amount) {
                    got.put(next, got.get(current) + 1);
                    q.add(next);
                }
            }
        }
        return -1;
    }
}