package lc756_PyramidTransitionMatrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class SolutionTest {

    @Test
    void pyramidTransition() {
        Solution s = new Solution();
        ArrayList<String> gfg = new ArrayList<String>(Arrays.asList("BCG", "CDE", "GEA", "FFF"));
        s.pyramidTransition("BCD", gfg);
    }
}