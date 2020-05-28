package lc435_NonOverlappingIntervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution s;

    @BeforeEach
    void setUp() {
        this.s = new Solution();
    }

    @Test
    void eraseOverlapIntervals() {
        assertEquals(4, s.eraseOverlapIntervals(new int[][]{
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{1, 3},
                new int[]{2, 4},
                new int[]{3, 5},
                new int[]{3, 5},
                new int[]{4, 6}}));

    }
}