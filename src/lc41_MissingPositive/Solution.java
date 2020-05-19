package lc41_MissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (current <= nums.length && current > 0 && nums[current - 1] != current) {
                int next = nums[current - 1];
                nums[current - 1] = current;
                if (next > 0 && next <= nums.length) {
                    current = next;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}