package lc130_SurroundedRegions;
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 */
class Solution {
    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] != 'O') return;
        board[r][c] = '-';
        if (r > 0) dfs(board, r-1, c);
        if (c > 0) dfs(board, r, c-1);
        if (r+1 < board.length) dfs(board, r+1, c);
        if (c+1 < board[0].length) dfs(board, r, c+1);
    }
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;

        for (int c = 0; c < board[0].length; c++) {
            dfs(board, 0, c);
            dfs(board, board.length-1, c);
        }
        for (int r = 1; r+1 < board.length; r++) {
            dfs(board, r, 0);
            dfs(board, r, board[0].length-1);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '-') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
}