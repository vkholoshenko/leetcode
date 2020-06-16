package lc135_Candy;

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
    void candy1() {
        assertEquals(5, s.candy(new int[]{1,0,2}));
    }
    @Test
    void candy2() {
        assertEquals(4, s.candy(new int[]{1,2,2}));
    }
    @Test
    void candy3() {
        assertEquals(7, s.candy(new int[]{1,3,2,2,1}));
    }
    @Test
    void candy4() {
        assertEquals(18, s.candy(new int[]{1,6,10,8,7,3,2}));
    }
    @Test
    void candy5() {
        assertEquals(11, s.candy(new int[]{1,3,4,5,2}));
    }
}