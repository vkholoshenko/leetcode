package lc162_FindPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int l = 0, r = nums.length-1;

        while (l < r) {
            int c = (l+r) / 2;
            if (c == 0 && nums[c+1] < nums[c] ||
                    c > 0 && nums[c-1] < nums[c] && nums[c+1] < nums[c] ||
                    c+1 == nums.length && nums[c-1] < nums[c]) {
                return c;
            }

            if (nums[c] < nums[c+1]) {
                l = c+1;
            } else {
                r = c-1;
            }
        }
        return l;
    }
}