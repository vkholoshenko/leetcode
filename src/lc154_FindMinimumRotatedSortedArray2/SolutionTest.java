package lc154_FindMinimumRotatedSortedArray2;

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
    void findMin() {
        assertEquals(1, s.findMin(new int[]{3,5,1}));
    }
}