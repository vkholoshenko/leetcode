package lc47_Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int[] nums;

    private List<List<Integer>> perms(int len) {
        List<List<Integer>> result = new ArrayList<>();
        if (len == 1) {
            List<Integer> perm = new ArrayList<>();
            perm.add(nums[0]);
            result.add(perm);
        } else if (len > 1) {
            for (int i = 0; i < len; i++) {
                if (i == 0 || nums[i-1] != nums[i]) {
                    int t = nums[i];
                    for (int j = i+1; j < len; j++) {
                        nums[j-1] = nums[j];
                    }
                    for (List<Integer> perm : perms(len-1)) {
                        perm.add(t);
                        result.add(perm);
                    }
                    for (int j = len-1; j > i; j--) {
                        nums[j] = nums[j-1];
                    }
                    nums[i] = t;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        this.nums = nums;
        return perms(nums.length);
    }
}