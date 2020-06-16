package lc260_SingleNumber3;
/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
exactly twice. Find the two elements that appear only once.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit = 1;
        while ((xor & bit) == 0) bit = bit << 1;

        int first = 0;
        for (int num : nums) {
            if ((num & bit) != 0) first ^= num;
        }
        return new int[]{first, first ^ xor};
    }
}