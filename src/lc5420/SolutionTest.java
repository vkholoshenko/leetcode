package lc5420;

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
    void test1() {
        assertArrayEquals(
            new int[]{4,2,4,2,3},
            s.finalPrices(new int[]{8,4,6,2,3})
        );
    }
    @Test
    void test2() {
        assertArrayEquals(
            new int[]{1,2,3,4,5},
            s.finalPrices(new int[]{1,2,3,4,5})
        );
    }
    @Test
    void test3() {
        assertArrayEquals(
            new int[]{9,0,1,6},
            s.finalPrices(new int[]{10,1,1,6})
        );
    }
}