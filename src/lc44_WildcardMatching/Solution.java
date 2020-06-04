package lc44_WildcardMatching;
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

 */

public class Solution {
    private String s;
    private String p;
    private boolean[][] tried;
    private boolean isSubMatch(int si, int pi) {
        if (tried[si][pi]) {
            return false;
        }
        if (si == s.length() && pi == p.length()) {
            return true;
        } else if (pi == p.length()) {
            tried[si][pi] = true;
            return false;
        } else if (si < s.length() &&
                (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
            return isSubMatch(si+1, pi+1);
        } else if (p.charAt(pi) == '*') {
            if (pi + 1 < p.length() && p.charAt(pi+1) == '*') {
                return isSubMatch(si, pi+1);
            } else {
                for (int i = si; i <= s.length(); i++) {
                    if (isSubMatch(i, pi+1)) {
                        return true;
                    } else {
                        tried[i][pi+1] = true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.tried = new boolean[s.length()+1][p.length()+1];
        return isSubMatch(0, 0);
    }
}