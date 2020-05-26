package lc207_CourseSchedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canFinish() {
        assertTrue(new Solution().canFinish(2, new int[][]{new int[]{0,1}}));
    }
}