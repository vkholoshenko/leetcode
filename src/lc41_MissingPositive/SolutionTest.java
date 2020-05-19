package lc41_MissingPositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void firstMissingPositive1() {
        Solution s = new Solution();
        assertEquals(6, s.firstMissingPositive(new int[]{3, 1, -1, 5, 7, 10, 3, 4, 2}));
    }
    @Test
    void firstMissingPositive2() {
        Solution s = new Solution();
        assertEquals(2, s.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}