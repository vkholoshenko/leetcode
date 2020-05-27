package lc329_LongestIncreasingPath;

class Solution {
    private int[][] calculated;
    // min == 2, row == 2, col == 1

    private int calculate(int[][] matrix, int min, int row, int col) {
        if (col < 0 || col >= matrix[0].length ||
                row < 0 || row >= matrix.length ||
                matrix[row][col] <= min) {
            return 0;
        }

        if (calculated[row][col] > 0) {
            return calculated[row][col];
        }

        int goLeft  = calculate(matrix, matrix[row][col], row, col-1); // 1
        int goUp    = calculate(matrix, matrix[row][col], row-1, col);
        int goRight = calculate(matrix, matrix[row][col], row, col+1);
        int goDown  = calculate(matrix, matrix[row][col], row+1, col); // 1

        this.calculated[row][col] = Math.max(Math.max(goLeft, goRight), Math.max(goUp, goDown)) + 1;
        return this.calculated[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        if (matrix.length == 0) {
            return 0;
        }
        this.calculated = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                result = Math.max(result,
                        calculate(matrix, matrix[r][c]-1, r, c));
            }
        }
        return result;
    }
}


