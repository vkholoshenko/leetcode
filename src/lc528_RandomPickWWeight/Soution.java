package lc528_RandomPickWWeight;
/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which
randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
 */
class Solution {
    private final int[] ws;

    public Solution(int[] w) {
        ws = new int[w.length];
        ws[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            ws[i] = ws[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int l = 0, r = ws.length-1;
        double rand = Math.random() * ws[r];

        while (l < r) {
            int c = (l + r) / 2;

            if (rand == ws[c] ||
                    rand < ws[c] && (c == 0 || ws[c-1] < rand)) {
                return c;
            }
            if (ws[c] < rand) {
                l = c + 1;
            } else if (ws[c] > rand) {
                r = c - 1;
            }
        }
        return l;
    }
}
