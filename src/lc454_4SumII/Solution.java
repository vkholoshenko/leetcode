package lc454_4SumII;

import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> cd = new HashMap<>();

        for (int c : C) {
            for (int d : D) {
                cd.put(c + d, 1 + cd.getOrDefault(c + d, 0));
            }
        }

        int result = 0;
        for (int a : A) {
            for (int b : B) {
                result += cd.getOrDefault(- (a + b), 0);
            }
        }
        return result;
    }
}