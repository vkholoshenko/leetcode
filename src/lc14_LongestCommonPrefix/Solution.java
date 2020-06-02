package lc14_LongestCommonPrefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.


 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String str0 = strs[0];
        for (int length = 0; length < str0.length(); length++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= length || strs[i].charAt(length) != str0.charAt(length)) {
                    return str0.substring(0, length);
                }
            }
        }
        return str0;
    }
}