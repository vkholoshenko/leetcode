package lc37_SudokuSolver;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */
public class Solution {
    char[][] board;

    private List<Character> possible(int R, int C) {
        List<Character> result = new ArrayList<>();
        boolean[] foundR = new boolean[9];
        boolean[] foundC = new boolean[9];
        boolean[] foundB = new boolean[9];
        int r = R;
        int c;
        for (c = 0; c < 9; c++) {
            int v = board[r][c] - '1';
            if (v >= 0 && v < 9) {
                foundR[v] = true;
            }
        }
        c = C;
        for (r = 0; r < 9; r++) {
            int v = board[r][c] - '1';
            if (v >= 0 && v < 9) {
                foundC[v] = true;
            }
        }
        int br = (R / 3) * 3;
        int bc = (C / 3) * 3;

        for (r = br; r < br+3; r++) {
            for (c = bc; c < bc+3; c++) {
                int v = board[r][c] - '1';
                if (v >= 0 && v < 9) {
                    foundB[v] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!(foundR[i] || foundC[i] || foundB[i])) {
                result.add(new Character((char)(i + '1')));
            }
        }
        return result;
    }
    public boolean solve(int R, int C) {
        for (int r = R; r < 9; r++) {
            int c;
            if (r == R) {
                c = C;
            } else {
                c = 0;
            }
            for (; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (Character ch: possible(r, c)) {
                        board[r][c] = ch;
                        if (solve(r, c)) {
                            return true;
                        }
                    }
                    board[r][c] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0,0);
    }
}
