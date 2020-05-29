package lc18_4Sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fourSum() {
        assertEquals(
                29,
                new Solution().fourSum(new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5}, 0).size());

        assertEquals(8,
            new Solution().fourSum(new int[]
                            {-495, -477, -464, -424, -411, -409, -363, -337, -328, -328, -325, -320, -310, -285, -278, -235, -208, -151, -149, -147, -144, -132, -115, -107, -101, -98, -83, -58, -58, -56, -51, -46, -45, -7, 0, 4, 4, 21, 51, 52, 57, 60, 104, 109, 124, 141, 158, 205, 206, 241, 278, 278, 291, 314, 379, 416, 437, 447, 452, 496},
                    -1371).size());
    }
}