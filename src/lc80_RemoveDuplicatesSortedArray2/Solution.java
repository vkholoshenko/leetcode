package lc80_RemoveDuplicatesSortedArray2;

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the
new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
extra memory.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int p = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[p] || nums[i] != nums[p-1]) {
                p++;
            }
            nums[p] = nums[i];
        }
        return p + 1;
    }
}