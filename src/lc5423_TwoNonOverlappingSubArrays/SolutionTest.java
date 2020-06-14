package lc5423_TwoNonOverlappingSubArrays;

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
    void minSumOfLengths1() {
        assertEquals(2, s.minSumOfLengths(new int[]{3,2,2,4,3}, 3));
    }
    @Test
    void minSumOfLengths2() {
        assertEquals(2, s.minSumOfLengths(new int[]{7,3,4,7}, 7));
    }
    @Test
    void minSumOfLengths3() {
        assertEquals(-1, s.minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6));
    }
    @Test
    void minSumOfLengths4() {
        assertEquals(-1, s.minSumOfLengths(new int[]{5,5,4,4,5}, 3));
    }
    @Test
    void minSumOfLengths5() {
        assertEquals(3, s.minSumOfLengths(new int[]{3,1,1,1,5,1,2,1}, 3));
    }
    @Test
    void minSumOfLengths6() {
        assertEquals(6, s.minSumOfLengths(new int[]{64,5,20,9,1,39}, 69));
    }
}