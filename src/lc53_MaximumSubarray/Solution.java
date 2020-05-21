package lc53_MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        // -3 -2 0 3 -1 2
        int result = nums[0]; // 4
        int current = result; // 4
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + current > 0) {
                current += nums[i];
            } else {
                current = nums[i];
            }
            if (nums[i] > current) {
                current = nums[i];
            }
            if (current > result) {
                result = current;
            }
        }
        return result;
    }
}
