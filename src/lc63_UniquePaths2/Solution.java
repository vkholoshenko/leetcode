package lc63_UniquePaths2;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.


 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[][] data = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0) data[0][0] = 1;
        for (int i = 1; i < data[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                data[0][i] = data[0][i-1];
            }
        }
        for (int i = 1; i < data.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                data[i][0] = data[i-1][0];
            }
        }

        for (int r = 1; r < data.length; r++) {
            for (int c = 1; c < data[r].length; c++) {
                if (obstacleGrid[r][c] == 0) {
                    data[r][c] = data[r-1][c] + data[r][c-1];
                }
            }
        }
        return data[data.length-1][data[0].length-1];
    }
}