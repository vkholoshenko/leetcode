package lc934_ShortestBridge;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    class Pair {
        public int r;
        public int c;
        public Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    private Deque<Pair> q;
    private int[][] A;

    private boolean tryCell(int r, int c, int d) {
        if (A[r][c] == 0) {
            A[r][c] = d;
            q.add(new Pair(r,c));
        } else if (A[r][c] == 1) {
            return true;
        }
        return false;
    }

    private void fill(int r, int c) {
        if (r < 0 || c < 0 || r >= A.length || c >= A[0].length) return;
        if (A[r][c] == 1) {
            A[r][c] = 2;
            fill(r-1,c);
            fill(r+1,c);
            fill(r,c-1);
            fill(r,c+1);
        }
    }

    public int shortestBridge(int[][] A) {
        int w = A[0].length;
        int h = A.length;
        this.A = A;
        this.q = new ArrayDeque<>();


        boolean filled = false;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (A[r][c] == 1) {
                    fill(r, c);
                    filled = true;
                    break;
                }
            }
            if (filled) break;
        }

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (A[r][c] == 2) {
                    q.add(new Pair(r,c));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair item = q.poll();
            int d = -1;
            if (A[item.r][item.c] < 0) {
                d += A[item.r][item.c];
            }

            if (item.r > 0 && tryCell(item.r-1, item.c, d) ||
                item.c > 0 && tryCell(item.r, item.c-1, d) ||
                item.r+1 < h && tryCell(item.r+1, item.c, d) ||
                item.c+1 < w && tryCell(item.r, item.c+1, d)) {
                return -d -1;
            }
        }
        return -1;
    }
}