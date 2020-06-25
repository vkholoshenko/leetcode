package lc410_SplitArrayLargestSum;

public class Solution {

    public int splitArray(int[] nums, int m) {
        int[][] previous = new int[nums.length][nums.length]; // k == 1
        for (int i = 0; i < nums.length; i++) previous[0][i] = nums[i];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i; j++) {
                previous[i][j] = previous[i-1][j] + nums[i+j];
            }
        }

        for (int step = 1; step < m; step++) {
            int[][] current = new int[nums.length][nums.length];
            for (int i = step; i < nums.length; i++) {
                for (int j = 0; j < nums.length-i; j++) {
                    int value = Integer.MAX_VALUE;
                    int group1 = 0, group2 = 0;
                    for (int t = 1; t <= i-step+1; t++) {
                        group1 += nums[j+t-1];
                        if (group1 >= value) break;

                        group2 = previous[i-t][j+t];
                        value = Math.min(value, Math.max(group1, group2));
                    }
                    current[i][j] = value;
                }
            }
            previous = current;
        }
        return previous[nums.length-1][0];
    }
}