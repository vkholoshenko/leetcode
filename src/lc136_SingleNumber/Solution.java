package lc136_SingleNumber;
/*
Given a non-empty array of integers, every element appears twice except for one.
Find that single one.


 */
public class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r ^= num;
        }
        return r;
    }
}