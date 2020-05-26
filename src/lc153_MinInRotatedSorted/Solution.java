package lc153_MinInRotatedSorted;

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // l = 3
        // r = 4
        // c = 3
        // left   = 1
        // center = 1
        // right  = 2

        while (l < r) {
            int left = nums[l];
            int right = nums[r];
            int c = (r + l) / 2;
            int center = nums[c];

            if (left <= center) {
                if (center <= right) {
                    return left;
                } else { // center > right
                    l = c + 1;
                }
            } else { // left > center
                r = c;
            }
        }
        return nums[l];
    }
}
