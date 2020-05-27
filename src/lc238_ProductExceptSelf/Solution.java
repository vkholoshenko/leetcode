package lc238_ProductExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int multiplier = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            multiplier *= nums[i+1];
            result[i] *= multiplier;
        }
        return result;
    }
}