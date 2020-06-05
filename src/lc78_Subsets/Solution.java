package lc78_Subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
 */
public class Solution {
    private List<List<Integer>> subsets(int[] nums, int l) {
        List<List<Integer>> result = new ArrayList<>();
        if (l == 0) {
            result.add(new ArrayList<>());
        } else {
            for (List<Integer> subset : subsets(nums, l-1)) {
                result.add(subset);
                List<Integer> subset2 = new ArrayList<>(subset);
                subset2.add(nums[l-1]);
                result.add(subset2);
            }
        }
        return result;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length);
    }
}
