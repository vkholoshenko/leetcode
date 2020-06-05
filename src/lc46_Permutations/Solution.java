package lc46_Permutations;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.
 */
public class Solution {
    private int[] nums;
    private List<List<Integer>> perms(int len) {
        List<List<Integer>> result = new ArrayList<>();

        if (len == 1) {
            List<Integer> perm = new ArrayList<>();
            perm.add(nums[0]);
            result.add(perm);
        } else {
            for (int i = 0; i < len; i++) {
                int t = nums[i];
                nums[i] = nums[len-1];
                for (List<Integer> perm : perms(len-1)) {
                    perm.add(t);
                    result.add(perm);
                }
                nums[i] = t;
            }
        }
        return result;
    }
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        return perms(nums.length);
    }
}