package lc15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> allNums = new HashSet<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int item : nums) {
            allNums.add(item);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    // -1
                    if (j == i + 1 || nums[j - 1] != nums[j]) {
                        int b = nums[j];
                        int c = - a - b;
                        if (c < b) {
                            break;
                        } else if (allNums.contains(c) && (c > b || j + 1 < nums.length && nums[j+1] == c)) {
                            ArrayList<Integer> triplet = new ArrayList<>();
                            triplet.add(a);
                            triplet.add(b);
                            triplet.add(c);
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
}