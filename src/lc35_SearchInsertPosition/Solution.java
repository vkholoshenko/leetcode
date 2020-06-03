package lc35_SearchInsertPosition;
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        if (r < 0) {
            return 0;
        }

        while (l < r) {
            int c = (l + r) / 2;
            if (nums[c] > target) {
                r = c - 1;
            } else if (nums[c] < target) {
                l = c + 1;
            } else {
                l = c;
                r = c;
            }
        }
        if (nums[l] >= target) {
            return l;
        } else {
            return l+1;
        }
    }
}