package lc51_NQueens;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.


 */
public class Solution {
    private int[][] board;
    private int n;
    private List<List<String>> results;

    private void markBoard(int R, int C, int from, int to) {
        board[R][C] = -to;
        for (int i = 0 ; i < n; i++) {
            if (board[R][i] == from) board[R][i] = to;
        }
        for (int i = R+1; i < n; i++) {
            if (board[i][C] == from) board[i][C] = to;
        }
        for (int i = 1; R+i < n && C+i < n; i++) {
            if (board[R+i][C+i] == from) board[R+i][C+i] = to;
        }
        for (int i = 1; R+i < n && C-i >= 0; i++) {
            if (board[R+i][C-i] == from) board[R+i][C-i] = to;
        }
    }

    private List<String> boardToResult() {
        List<String> result = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                if (board[r][c] < 0) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private void solve(int r) {
        if (r == n) {
            this.results.add(this.boardToResult());
            return;
        }
        for (int c = 0; c < n; c++) {
            if (board[r][c] == 0) {
                markBoard(r, c, 0, r+1);
                solve(r+1);
                markBoard(r, c, r+1, 0);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.board = new int[n][n];
        this.n = n;
        this.results = new ArrayList<>();

        solve(0);
        return this.results;
    }
}