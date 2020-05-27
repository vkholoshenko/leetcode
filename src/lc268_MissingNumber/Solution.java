package lc268_MissingNumber;

class Solution {
    public int missingNumber(int[] nums) {
        for (int i=0; i < nums.length; i++) {
            int j = nums[i];
            while (j < nums.length && nums[j] != j) {
                int t = nums[j];
                nums[j] = j;
                j = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}