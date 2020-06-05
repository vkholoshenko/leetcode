package lc115_DistinctSubsequences;
/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] data = new int[t.length()+1][s.length()+1];
        for (int i = 0; i <= s.length(); i++) data[0][i] = 1;

        for (int i = 1; i <= t.length(); i++) {
            char ct = t.charAt(i-1);
            for (int j = i; j <= s.length(); j++) {
                char cs = s.charAt(j-1);

                data[i][j] = data[i][j-1]; // just add one more letter to delete

                if (cs == ct) { // or add same letter to S and T
                    data[i][j] += data[i-1][j-1];
                }
            }
        }
        return data[t.length()][s.length()];
    }
}