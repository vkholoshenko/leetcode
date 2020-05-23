package lc57_InsertInterval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void insert() {
        new Solution().insert(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{6, 9}},
                new int[]{2,5});
    }
}