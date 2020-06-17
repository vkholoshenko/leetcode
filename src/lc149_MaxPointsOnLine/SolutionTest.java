package lc149_MaxPointsOnLine;

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
    void maxPoints() {
        assertEquals(2, s.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{94911150, 94911151},
                new int[]{94911151, 94911152}}));
    }

    @Test
    void maxPoints1() {
        assertEquals(2, s.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{94911151, 94911150},
                new int[]{94911152, 94911151}}));
    }

    @Test
    void maxPoints2() {
        assertEquals(4, s.maxPoints(new int[][]{
                new int[]{3, 1},
                new int[]{12, 3},
                new int[]{3, 1},
                new int[]{-6, -1}}));
    }

    @Test
    void maxPoints3() {
        assertEquals(4, s.maxPoints(new int[][]{
                new int[]{1, 1},
                new int[]{3, 2},
                new int[]{5, 3},
                new int[]{4, 1},
                new int[]{2, 3},
                new int[]{1, 4}}));
    }

    @Test
    void maxPoints4() {
        assertEquals(3, s.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 0}}));
    }
    @Test
    void maxPoints5() {
        assertEquals(2, s.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{1, 65536},
                new int[]{65536, 0}}));
    }
}