package lc115_DistinctSubsequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numDistinct() {
        assertEquals(5, new Solution().numDistinct("babgbag", "bag"));
    }
}