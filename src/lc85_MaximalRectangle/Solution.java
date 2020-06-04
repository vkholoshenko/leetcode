package lc85_MaximalRectangle;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == '1') heights[0][c] = 1;
        }
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == '1') heights[r][c] = heights[r-1][c] + 1;
            }
        }
        int[] qh = new int[matrix[0].length+1];
        int[] qi = new int[matrix[0].length+1];
        int p;
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            p = 0;
            for (int c = 0; c <= matrix[0].length; c++) {
                int h = 0;
                if (c < matrix[0].length) h = heights[r][c];
                int idx = c;
                while (qh[p] > h) {
                    int sq = (c - qi[p]) * qh[p];
                    if (sq > max) max = sq;
                    idx = qi[p];
                    p--;
                }
                if (h > qh[p]) {
                    p++;
                    qh[p] = h;
                    qi[p] = idx;
                }
            }
        }

        return max;
    }
}