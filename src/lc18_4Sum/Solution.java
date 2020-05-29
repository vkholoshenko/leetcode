package lc18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> sums2 = new HashMap<>();

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (!sums2.containsKey(sum)) {
                    sums2.put(sum, new ArrayList<>());
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                sums2.get(sum).add(pair);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            if (i > 0  && nums[i-1] == nums[i]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if (j > i + 1 && nums[j-1] == nums[j]) continue;
                int sum = nums[i] + nums[j];
                int need = target - sum;
                if (sums2.containsKey(need)) {
                    List<List<Integer>> pairs = sums2.get(need);
                    for (List<Integer> pair : pairs) {
                        if (pair.get(0) > j) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[pair.get(0)], nums[pair.get(1)]));
                        }
                    }
                }
            }
        }
        List<List<Integer>> filtered = new ArrayList<>();
        List<Integer> prev = null;
        for (List<Integer> quadruplet : result) {
            if (prev == null ||
               !prev.get(0).equals(quadruplet.get(0)) ||
               !prev.get(1).equals(quadruplet.get(1)) ||
               !prev.get(2).equals(quadruplet.get(2))) {
                filtered.add(quadruplet);
                prev = quadruplet;
            }
        }
        return filtered;
    }
}