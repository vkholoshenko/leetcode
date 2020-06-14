package lc90_Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int[] nums;
    private List<List<Integer>> subsets(int startIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (startIndex == nums.length) {
            result.add(new ArrayList<>());
            return result;
        }

        int dups = startIndex;
        while  (dups < nums.length && nums[dups] == nums[startIndex]) dups++;

        List<List<Integer>> subresult = subsets(dups);
        for (List<Integer> item : subresult) {
            result.add(item);
            for (int i = startIndex; i < dups; i++) {
                List<Integer> newItem = new ArrayList<>(item);
                for (int j = startIndex; j <= i; j++) {
                    newItem.add(nums[startIndex]);
                }
                result.add(newItem);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        return subsets(0);
    }
}