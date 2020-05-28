package lc417_PacificAtlanticWater;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.


Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 */
class Solution {
    private void fill(int[][] matrix, boolean[][] filled, int r, int c) {
        filled[r][c] = true;

        if (r > 0 && !filled[r-1][c] && matrix[r-1][c] >= matrix[r][c]) {
            fill(matrix, filled, r-1, c);
        }
        if (r < matrix.length-1 && !filled[r+1][c] && matrix[r+1][c] >= matrix[r][c]) {
            fill(matrix, filled, r+1, c);
        }
        if (c > 0 && !filled[r][c-1] && matrix[r][c-1] >= matrix[r][c]) {
            fill(matrix, filled, r, c-1);
        }
        if (c < matrix[0].length-1 && !filled[r][c+1] && matrix[r][c+1] >= matrix[r][c]) {
            fill(matrix, filled, r, c+1);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        boolean[][] po = new boolean[matrix.length][matrix[0].length];
        boolean[][] ao = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            fill(matrix, po, i, 0);
            fill(matrix, ao, i, matrix[0].length-1);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            fill(matrix, po, 0, j);
            fill(matrix, ao, matrix.length-1, j);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (po[i][j] && ao[i][j]) {
                    List<Integer> next = new ArrayList<>();
                    next.add(i);
                    next.add(j);
                    result.add(next);
                }
            }
        }
        return result;
    }
}