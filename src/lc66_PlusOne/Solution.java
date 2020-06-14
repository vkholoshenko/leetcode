package lc66_PlusOne;
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length-1;
        digits[p]++;
        while(digits[p] >= 10 && p > 0) {
            digits[p] -= 10;
            digits[p-1]++;
            p--;
        }
        int[] result = digits;
        if (digits[0] > 9) {
            result = new int[digits.length + 1];
            result[0] = 1;
            digits[0] -= 10;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return result;
    }
}