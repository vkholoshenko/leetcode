package lc59_SpiralMatrix2;
/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n² in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        for (int o = 0; o < n/2; o++) {
            for (int i = o; i < n-o-1; i++) {
                result[o][i] = ++x;
            }
            for (int i = o; i < n-o-1; i++) {
                result[i][n-o-1] = ++x;
            }
            for (int i = n-o-1; i > o; i--) {
                result[n-o-1][i] = ++x;
            }
            for (int i = n-o-1; i > o; i--) {
                result[i][o] = ++x;
            }
        }
        if (n % 2 > 0) {
            result[n/2][n/2] = ++x;
        }

        return result;
    }
}
