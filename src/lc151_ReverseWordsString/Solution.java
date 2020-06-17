package lc151_ReverseWordsString;

import java.util.Stack;

// 5:30
/*
Given an input string, reverse the string word by word.

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/
class Solution {
    public String reverseWords(String s) {
        int n = s.length(), i = 0;
        Stack<String> stack = new Stack<>();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++;
            int start = i;
            while (i < n && s.charAt(i) != ' ') i++;
            if (i > start) stack.push(s.substring(start, i));
        }

        if (stack.empty()) return "";

        StringBuilder result = new StringBuilder(stack.pop());
        while (!stack.empty()) {
            result.append(' ');
            result.append(stack.pop());
        }
        return result.toString();
    }
}