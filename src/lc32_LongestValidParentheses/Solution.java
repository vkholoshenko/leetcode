package lc32_LongestValidParentheses;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int best = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.empty()) {
                    if (i - start > best) {
                        best = i - start;
                    }
                    start = i+1;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        int prev = s.length();
        while (!stack.empty()) {
            int curr = stack.pop();
            if (prev - curr - 1 > best) {
                best = prev - curr - 1;
            }
            prev = curr;
        }
        if (prev - start > best) {
            best = prev - start;
        }
        return best;
    }
}