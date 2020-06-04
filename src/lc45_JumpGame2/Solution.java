package lc45_JumpGame2;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
 */
public class Solution {
    public int jump(int[] nums) {
        // [2 3 1 1 4]
        // [1 2 2 3 3]
        int[] jumps = new int[nums.length];
        jumps[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int jump = jumps[i] + 1;
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (jump < jumps[i+j] || jumps[i+j] == 0) {
                    jumps[i+j] = jump;
                }
            }
        }
        return jumps[nums.length - 1] - 1;
    }
}