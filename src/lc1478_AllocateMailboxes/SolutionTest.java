package lc1478_AllocateMailboxes;

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
    void buildUsing1() {
        assertArrayEquals(
                new int[][]{
                        new int[]{ 0, 0, 0, 0,0},
                        new int[]{ 3, 4, 2,10,0},
                        new int[]{ 7, 6,12, 0,0},
                        new int[]{13,18, 0, 0,0},
                        new int[]{25, 0, 0, 0,0}
                },
                s.buildUsing1(new int[]{1,4,8,10,20}));
    }

    @Test
    void minDistance1() {
        assertEquals(5,
                s.minDistance(new int[]{1,4,8,10,20}, 3));
    }
    @Test
    void minDistance2() {
        assertEquals(9,
                s.minDistance(new int[]{2,3,5,12,18}, 2));
    }
    @Test
    void minDistance3() {
        assertEquals(8,
                s.minDistance(new int[]{7,4,6,1}, 1));
    }
}