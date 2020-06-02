package lc10_RegularExpressionMatching;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */
class Solution {
    private boolean isMatch(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (pi + 1 < p.length() && p.charAt(pi+1) == '*') {
            if (isMatch(s, p, si, pi+2)) {
                return true;
            }
            if (si < s.length() &&
                    (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi))) {
                return isMatch(s, p, si+1, pi);
            }
        } else if (pi < p.length() && si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi))) {
            return isMatch(s, p, si+1, pi+1);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
}
