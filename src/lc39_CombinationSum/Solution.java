package lc39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution9 {

    public List<List<Integer>> combinations(int[] candidates, int n, int target) {
        // 2 3 6 7   7
        ArrayList<List<Integer>> results = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            int candidate = candidates[i]; // 6
            if (candidate == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(candidate);
                results.add(result);
            } else if (candidate < target) {
                for (List<Integer> subresult : combinations(candidates, i+1, target - candidate)) {
                    subresult.add(candidate);
                    results.add(subresult);
                }
            }
        }
        return results;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinations(candidates, candidates.length, target);
    }
}

