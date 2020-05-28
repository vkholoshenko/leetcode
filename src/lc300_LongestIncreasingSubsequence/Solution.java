package lc300_LongestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // [10,9,2,5,3,7,101,18]
        // [ 2,2,4,3,3,2,  1, 1]

        int[] calculated = new int[nums.length];

        for (int i = nums.length-1; i >= 0 ; i--) {
            int best = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && calculated[j] +1 > best) {
                    best = calculated[j] + 1;
                }
            }
            calculated[i] = best;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, calculated[i]);
        }
        return result;
    }
}
