package lc54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rc = matrix.length;
        if (rc == 0) {
            return result;
        }
        int cc = matrix[0].length;
        if (cc == 0) {
            return result;
        }

        int omax = Math.min(rc,cc) / 2;
        for (int o = 0; o < omax; o++) {
            for (int c = o; c < cc - o; c++) {
                result.add(matrix[o][c]);
            }
            for (int r = o + 1; r < rc - o; r++) {
                result.add(matrix[r][cc-o-1]);
            }
            for (int c = cc-o-2; c >= o; c--) {
                result.add(matrix[rc-o-1][c]);
            }
            for (int r = rc-o-2; r > o; r--) {
                result.add(matrix[r][o]);
            }
        }
        if (Math.min(rc,cc) % 2 > 0) {
            for (int r = omax; r < rc - omax; r++) {
                for (int c = omax; c < cc - omax; c++) {
                    result.add(matrix[r][c]);
                }
            }
        }
        return result;
    }
}