package lc31_NextPermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nextPermutation() {
        int[] nums = new int[]{1,5,1};
        new Solution().nextPermutation(nums);
        assertArrayEquals(new int[]{5,1,1}, nums);
    }
}