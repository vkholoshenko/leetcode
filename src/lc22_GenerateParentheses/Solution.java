package lc22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution {
    private List<String> generate(String beginning, int balance, int n) {
        List<String> result = new ArrayList<>();
        if (beginning.length() == n * 2) {
            result.add(beginning);
        } else {
            if (balance > 0) {
                result.addAll(generate(beginning + ")", balance - 1, n));
            }
            if (balance < n && 2 * n - beginning.length() > balance) {
                result.addAll(generate(beginning + "(", balance + 1, n));
            }
        }
        return result;
    }

    public List<String> generateParenthesis(int n) {
        return generate("", 0, n);
    }
}

