package lc137_SingleNumber2;
/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        int[] counters = new int[32];
        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if ((num & (1 << bit)) != 0) counters[bit]++;
            }
        }
        int result = 0;
        for (int bit = 0; bit < 32; bit++) {
            if (counters[bit] % 3 > 0) {
                result |= (1 << bit);
            }
        }
        return result;
    }
}