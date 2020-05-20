package lc11_Container;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left <= right) {
            int current = (right - left) * Math.min(height[left], height[right]);
            if (current > max) {
                max = current;
            }

            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
