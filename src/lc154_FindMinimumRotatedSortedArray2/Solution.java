package lc154_FindMinimumRotatedSortedArray2;

public class Solution {
    private int findMin(int[] nums, int l, int r) {
        while (l < r) {
            if (r <= l + 1) {
                return Math.min(nums[l], nums[r]);
            }

            int c = (l+r) / 2;
            if (nums[c] > nums[l]) {
                if (nums[r] > nums[l]) return nums[l];
                return Math.min(findMin(nums, l, c-1), findMin(nums, c+1, r));
            } else if (nums[c] == nums[l]) {
                return Math.min(findMin(nums, l, c-1), findMin(nums, c+1, r));
            } else {
                r = c;
            }
        }
        return nums[l];

    }
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
}