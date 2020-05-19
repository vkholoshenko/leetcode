package lc786_kthSmallestPrimeFactor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void kthSmallestPrimeFraction() {
        Solution s = new Solution();
        int[] A = new int[]{1, 2, 3, 5};

        int[] result = new int[]{2,5};
        assertArrayEquals(result,s.kthSmallestPrimeFraction(A, 3));
    }
}