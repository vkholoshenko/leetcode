package lc212_WordSearch2;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean findWord(boolean[][] visited, char[][] board, String word, int r, int c, int index) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        boolean result =
                findWord(visited, board, word, r+1, c, index + 1) ||
                        findWord(visited, board, word, r-1, c, index + 1) ||
                        findWord(visited, board, word, r, c+1, index + 1) ||
                        findWord(visited, board, word, r, c-1, index + 1);

        visited[r][c] = false;
        return result;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board.length > 0) {
            for (String word : words) {
                boolean found = false;
                boolean[][] visited = new boolean[board.length][board[0].length];
                for (int r = 0; r < board.length; r++) {
                    for (int c = 0; c < board[0].length; c++) {
                        if (findWord(visited, board, word, r, c, 0)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    result.add(word);
                }
            }
        }
        return result;
    }
}