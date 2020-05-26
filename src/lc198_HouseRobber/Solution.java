package lc198_HouseRobber;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int with = nums[0];
        int without = 0;
        for (int i = 1; i < nums.length; i++) {
            int newWith = without + nums[i];
            without = Math.max(without, with);
            with = newWith;
        }
        return Math.max(with, without);
    }
}