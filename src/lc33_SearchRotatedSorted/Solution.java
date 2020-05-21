package lc33_SearchRotatedSorted;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int idx = (left + right) / 2;
            if (nums[idx] == target) {
                return idx;
            } else if (nums[idx] > target) {
                if (nums[left] <= target || nums[left] > nums[idx]) {
                    right = idx - 1;
                } else {
                    left = idx + 1;
                }
            } else { // nums[idx] < target
                if (nums[right] >= target || nums[right] < nums[idx]) {
                    left = idx + 1;
                } else {
                    right = idx - 1;
                }
            }
        }
        return -1;
    }
}