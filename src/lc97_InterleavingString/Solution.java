package lc97_InterleavingString;
/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() + s2.length() == 0) {
            return true;
        }

        boolean[][] acc = new boolean[s1.length()+1][s2.length()+1];
        acc[0][0] = true;
        for (int i = 0; i < s1.length() && s1.charAt(i) == s3.charAt(i); i++) acc[i+1][0] = true;
        for (int i = 0; i < s2.length() && s2.charAt(i) == s3.charAt(i); i++) acc[0][i+1] = true;

        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1);

                acc[i][j] = (acc[i-1][j] && c1 == c3 || acc[i][j-1] && c2 == c3);
            }
        }

        return acc[s1.length()][s2.length()];
    }
}