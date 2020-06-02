package lc7_ReverseInteger;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean minus = (x < 0);
        int PRE_MAX = Integer.MAX_VALUE / 10;
        int LAST_DIGIT = Integer.MAX_VALUE % 10 + 1;
        if (minus) {
            x = -x;
        }
        while (x > 0) {
            int digit = x % 10;
            if (result > PRE_MAX ||
                    result == PRE_MAX && (digit > LAST_DIGIT || digit == LAST_DIGIT && !minus)) {
                return 0;
            }

            result = result * 10 + digit;
            x = x / 10;
        }

        if (minus) {
            result = -result;
        }
        return result;
    }
}