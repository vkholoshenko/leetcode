package lc153_MinInRotatedSorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMin() {
        assertEquals(1, new Solution().findMin(new int[]{3,4,5,1,2}));
    }
}