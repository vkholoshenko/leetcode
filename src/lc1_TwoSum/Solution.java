package lc1_TwoSum;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, HashSet<Integer>> storage = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> hs = storage.getOrDefault(nums[i], new HashSet<>());
            hs.add(i);
            storage.put(nums[i], hs);
        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int req = target - nums[i];
            HashSet<Integer> indexes = storage.get(req);
            if (indexes != null) {
                for (int index : indexes) {
                    if (index != result[0]) {
                        result[1] = index;
                        return result;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}