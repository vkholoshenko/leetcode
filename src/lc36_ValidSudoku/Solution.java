package lc36_ValidSudoku;
/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */
public class Solution {
    private char[][] board;

    private boolean invalidRow(int r) {
        boolean found[] = new boolean[9];
        for (int c = 0; c < 9; c++) {
            int v = board[r][c] - '1';
            if (v >= 0 && c < 9) {
                if (found[v]) return true;
                found[v] = true;
            }
        }
        return false;
    }
    private boolean invalidCol(int c) {
        boolean found[] = new boolean[9];
        for (int r = 0; r < 9; r++) {
            int v = board[r][c] - '1';
            if (v >= 0 && c < 9) {
                if (found[v]) return true;
                found[v] = true;
            }
        }
        return false;
    }
    private boolean invalidBox(int R, int C) {
        boolean found[] = new boolean[9];
        for (int r = R; r < R + 3; r++) {
            for (int c = C; c < C + 3; c++) {
                int v = board[r][c] - '1';
                if (v >= 0 && c < 9) {
                    if (found[v]) return true;
                    found[v] = true;
                }
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for (int r = 0; r < 9; r++) {
            if (invalidRow(r)) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (invalidCol(c)) {
                return false;
            }
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (invalidBox(r, c)) {
                    return false;
                }
            }
        }
        return true;

    }
}
