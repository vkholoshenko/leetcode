package lc213_HouseRobber2;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        // use first (0)
        int best = 0;
        int withPrev = nums[0] + nums[2];
        int withoutPrev = nums[0];
        for (int i = 3; i < nums.length - 1; i++) {
            int withCurrent = withoutPrev + nums[i];
            int withoutCurrent = Math.max(withoutPrev, withPrev);
            withPrev = withCurrent;
            withoutPrev = withoutCurrent;
        }
        best = Math.max(withPrev, withoutPrev);

        // don't use first (0)
        withPrev = nums[1];
        withoutPrev = 0;
        for (int i = 2; i < nums.length; i++) {
            int withCurrent = withoutPrev + nums[i];
            int withoutCurrent = Math.max(withoutPrev, withPrev);
            withPrev = withCurrent;
            withoutPrev = withoutCurrent;
        }
        best = Math.max(best, Math.max(withPrev, withoutPrev));

        return best;

    }
}