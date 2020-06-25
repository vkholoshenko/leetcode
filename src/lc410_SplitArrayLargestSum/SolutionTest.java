package lc410_SplitArrayLargestSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void splitArray() {
        assertEquals(11, new Solution().splitArray(
                new int[]{5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6},
                17));
    }
}