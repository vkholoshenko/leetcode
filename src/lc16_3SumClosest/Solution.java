package lc16_3SumClosest;

import java.util.Arrays;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

 */
public class Solution {
    private int find(int[] nums, int l, int r, int target) {
        if (nums[l] >= target) {
            return nums[l];
        }
        if (nums[r] <= target) {
            return nums[r];
        }
        while (l + 1 < r) {
            int c = (l+r) / 2;
            if (nums[c] < target) {
                l = c;
            } else if (nums[c] > target) {
                r = c;
            } else {
                return nums[c];
            }
        }
        if (Math.abs(target - nums[l]) < Math.abs(target - nums[r])) {
            return nums[l];
        } else {
            return nums[r];
        }
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2]; // -3

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int need = target - nums[i] - nums[j];
                int found = find(nums, j+1, nums.length-1, need) + nums[i] + nums[j];
                if (Math.abs(target - found) < Math.abs(target - result)) {
                    result = found;
                }
            }
        }
        return result;
    }
}