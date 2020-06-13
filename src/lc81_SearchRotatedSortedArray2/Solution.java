package lc81_SearchRotatedSortedArray2;

public class Solution {
    private int[] nums;
    private int target;

    private boolean search(int left, int right) {
        if (left >= right) {
            return nums[left] == target;
        }

        while (left < right) {
            int center = (left+right) / 2;
            if (nums[center] == target) {
                return true;
            }

            if (nums[left] < nums[center]) {
                if (nums[left] <= target && target < nums[center]) {
                    right = center - 1;
                } else {
                    left = center + 1;
                }
            } else if (nums[center] < nums[right]) { // nums[center] < nums[right]
                if (nums[center] < target && target <= nums[right]) {
                    left = center + 1;
                } else {
                    right = center - 1;
                }
            } else {
                return search(left, center-1) || search(center+1, right);
            }
        }
        return nums[left] == target;

    }

    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if (nums.length == 0) {
            return false;
        }
        return search(0, nums.length-1);

    }
}
