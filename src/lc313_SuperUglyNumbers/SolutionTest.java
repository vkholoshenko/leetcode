package lc313_SuperUglyNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nthSuperUglyNumber() {
        Solution s = new Solution();

        int array1[] = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
        for (int i=0; i < 1; i++) {
            assertEquals(1092889481, s.nthSuperUglyNumber(100000, array1));
        }

        int array2[] = {2};
        assertEquals(2, s.nthSuperUglyNumber(2, array2));
    }
}