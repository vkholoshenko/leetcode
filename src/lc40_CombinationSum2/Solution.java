package lc40_CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */
public class Solution {
    private int[] cands;
    private int target;

    public List<List<Integer>> comb(int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
        }
        for (int i = start; i < cands.length && cands[i] <= target; i++) {
            if (i == start || cands[i] > cands[i-1]) {
                for (List<Integer> subResult : comb(target - cands[i], i+1)) {
                    subResult.add(cands[i]);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.cands = candidates;

        return comb(target, 0);
    }
}