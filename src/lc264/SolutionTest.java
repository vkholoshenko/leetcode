package lc264;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nthUglyNumber() {
        Solution s = new Solution();
        assertEquals(1, s.nthUglyNumber(1));
        assertEquals(2, s.nthUglyNumber(2));
        assertEquals(3, s.nthUglyNumber(3));
        assertEquals(4, s.nthUglyNumber(4));
        assertEquals(5, s.nthUglyNumber(5));
        assertEquals(6, s.nthUglyNumber(6));
        assertEquals(8, s.nthUglyNumber(7));
        assertEquals(9, s.nthUglyNumber(8));
        assertEquals(10, s.nthUglyNumber(9));
        assertEquals(2123366400, s.nthUglyNumber(1690));
    }
}