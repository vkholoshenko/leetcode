package lc74_Search2dMatrix;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

 */
public class Solution {
    private int get(int[][] matrix, int index) {
        return matrix[index / matrix[0].length][index % matrix[0].length];
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int l = 0, r = matrix.length * matrix[0].length - 1;
        while (l < r) {
            int c = (l+r) / 2;
            int v = get(matrix, c);
            if (v == target) {
                return true;
            } else if (v > target) {
                r = c-1;
            } else {
                l = c+1;
            }
        }
        return get(matrix, l) == target;
    }
}