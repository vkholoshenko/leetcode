package lc56MergeIntervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortIntervals() {
        Solution s = new Solution();
        int[][] array = new int[][]{
                new int[]{2, 3},
                new int[]{1, 2},
                new int[]{4, 3},
                new int[]{2, 3}};
        s.sortIntervals(array, 0, array.length - 1);
        for (int[] i : array) {
            System.out.printf("%d, %d\n", i[0], i[1]);
        }
    }

    @Test
    void sortIntervals2() {
        Solution s = new Solution();
        int[][] array = new int[][]{
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{6, 7},
                new int[]{8, 9},
                new int[]{1, 10}};
        s.sortIntervals(array, 0, array.length - 1);
        for (int[] i : array) {
            System.out.printf("%d, %d\n", i[0], i[1]);
        }
    }

    @Test
    void sortIntervals3() {
        Solution s = new Solution();
        int[][] array = new int[][]{
                new int[]{4,5},
                new int[]{2,4},
                new int[]{4,6},
                new int[]{3,4},
                new int[]{0,0},
                new int[]{1,1},
                new int[]{3,5},
                new int[]{2,2}
                };
        s.sortIntervals(array, 0, array.length - 1);
        for (int[] i : array) {
            System.out.printf("%d, %d\n", i[0], i[1]);
        }
    }

    @Test
    void merge() {
        int[][] array = new int[][]{
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{6, 7},
                new int[]{8, 9},
                new int[]{1, 10}};


        for (int[] i : new Solution().merge(array)) {
            System.out.printf("%d, %d\n", i[0], i[1]);
        }

    }
}