package lc4_MedianTwoArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setUp() {
        s = new Solution();
    }

    @Test
    void find() {
        assertEquals(1, s.find(1, new int[]{0, 2}, 0, 1));
        assertEquals(2, s.find(1, new int[]{0, 1}, 0, 1));
        assertEquals(1, s.find(1, new int[]{1, 2}, 0, 1));
        assertEquals(2, s.find(1, new int[]{0, 1, 2}, 0, 2));
        assertEquals(3, s.find(5, new int[]{1,2,3}, 0, 2));

        assertEquals(7, s.find(1, new int[]{1,1,1,1,1,1,1,2,3}, 0, 8));
    }

    @Test
    void findMedianSortedArrays0() {
        assertEquals(1, s.findMedianSortedArrays(
                new int[]{1,1,1,1},
                new int[]{1,2}));
    }
    @Test
    void findMedianSortedArrays15() {
        assertEquals(1.5, s.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{1, 2}));
    }

    @Test
    void findMedianSortedArrays2() {
        assertEquals(2, s.findMedianSortedArrays(
                new int[]{1,3},
                new int[]{2}));

    }

    @Test
    void findMedianSortedArrays3() {
        assertEquals(40, s.findMedianSortedArrays(
                new int[]{10, 20, 30, 40, 50},
                new int[]{20, 60, 100, 110}));

    }

    @Test
    void findMedianSortedArrays4() {
        assertEquals(45, s.findMedianSortedArrays(
                new int[]{10, 20,    30, 40, 50, 60},
                new int[]{        20,                60, 100, 110}));
    }
    @Test
    void findMedianSortedArrays5() {
        assertEquals(1, s.findMedianSortedArrays(
                new int[]{1,1,1,1,1},
                new int[]{}));
    }
}