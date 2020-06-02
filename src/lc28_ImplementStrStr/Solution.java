package lc28_ImplementStrStr;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, needle.length() + i).equals(needle)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
