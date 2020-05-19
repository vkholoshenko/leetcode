package lc454_4SumII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fourSumCount() {
        Solution s = new Solution();
        assertEquals(2, s.fourSumCount(
                new int[]{ 1,  2},
                new int[]{-2, -1},
                new int[]{-1,  2},
                new int[]{ 0,  2}));
    }
}