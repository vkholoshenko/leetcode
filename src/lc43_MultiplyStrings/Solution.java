package lc43_MultiplyStrings;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int length = num1.length() + num2.length();
        int[] result = new int[length];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                result[i+j] += (num1.charAt(l1-i-1) - '0') * (num1.charAt(l2-j-1) - '0');
                result[i+j+1] += (result[i+j] / 10);
                result[i+j] = result[i+j] % 10;
            }
        }

        int i = length-1;
        while (i > 0 && result[i] == 0) i--;
        StringBuilder sb = new StringBuilder();
        for (;i >= 0; i--) {
            sb.append((char)(result[i] + '0'));
        }

        return sb.toString();
    }
}