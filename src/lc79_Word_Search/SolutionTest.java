package lc79_Word_Search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void existSEE() {
        assertTrue(new Solution().exist(
                new char[][]{
                        new char[]{'A','B','C','E'},
                        new char[]{'S','F','C','S'},
                        new char[]{'A','D','E','E'}},
                "SEE"
        ));
    }
    @Test
    void existABCCED() {
        assertTrue(new Solution().exist(
                new char[][]{
                        new char[]{'A','B','C','E'},
                        new char[]{'S','F','C','S'},
                        new char[]{'A','D','E','E'}},
                "ABCCED"
        ));
    }
}