package lc42_TrappingRainWater;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

public class Solution {
    public int trap(int[] height) {
        int result = 0;
        if (height.length > 2) {
            int maxPos = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > height[maxPos]) {
                    maxPos = i;
                }
            }

            int curMax = height[0];
            for (int i = 1; i < maxPos; i++) {
                int h = height[i];
                if (h > curMax) {
                    curMax = h;
                } else {
                    result += (curMax - h);
                }
            }

            curMax = height[height.length-1];

            for (int i = height.length-2; i > maxPos; i--) {
                int h = height[i];
                if (h > curMax) {
                    curMax = h;
                } else {
                    result += (curMax - h);
                }
            }
        }
        return result;
    }
}