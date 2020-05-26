package lc200_NumberIslands;

class Solution {
    char[][] grid;

    private void fill(int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = 'x';
        fill(r-1, c);
        fill(r+1, c);
        fill(r, c-1);
        fill(r, c+1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    result++;
                    fill(r, c);
                }
            }
        }
        return result;
    }
}