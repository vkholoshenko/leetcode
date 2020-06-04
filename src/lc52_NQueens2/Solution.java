package lc52_NQueens2;
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class Solution {
    private int[][] board;
    private int n;
    private int results = 0;

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

    private void solve(int r) {
        if (r == n) {
            this.results++;
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

    public int totalNQueens(int n) {
        this.board = new int[n][n];
        this.n = n;

        solve(0);
        return this.results;
    }
}