package lc34_FindFirstLastPosSortedArray;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int l = 0, r = nums.length-1;
        int[] result = new int[2];

        while (l < r) {
            int c = (l + r) / 2;
            if (nums[c] > target) {
                r = c - 1;
            } else if (nums[c] < target) {
                l = c + 1;
            } else {
                r = c;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1,-1};
        }
        result[0] = l;
        r = nums.length - 1;
        while (l < r) {
            int c = (l + r) / 2;
            if (nums[c] > target) {
                r = c - 1;
            } else if (nums[c] == target) {
                if (c > l) {
                    l = c;
                } else if (nums[r] == target) {
                    l = r;
                } else {
                    r = l;
                }
            }
        }
        result[1] = r;
        return result;
    }
}