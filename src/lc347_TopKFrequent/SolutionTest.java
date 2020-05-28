package lc347_TopKFrequent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void topKFrequent1() {
        assertArrayEquals(
                new int[]{1, 2},
                new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2)
        );
    }
    @Test
    void topKFrequent() {
        assertArrayEquals(
                new int[]{-1, 2},
                new Solution().topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)
        );
    }
}