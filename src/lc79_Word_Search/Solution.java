package lc79_Word_Search;

class Solution {
    private String word;
    private boolean[][] used;
    private char[][] board;

    private boolean go(int row, int column, int startIndex) {
        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length &&
                used[row][column] == false &&
                board[row][column] == word.charAt(startIndex)) {
            if (startIndex + 1 == word.length()) {
                return true;
            } else {
                used[row][column] = true;
                boolean result = go(row - 1, column, startIndex + 1) ||
                        go(row + 1, column, startIndex + 1) ||
                        go(row, column - 1, startIndex + 1) ||
                        go(row, column + 1, startIndex + 1);
                used[row][column] = false;
                return result;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        this.used = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (go(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}