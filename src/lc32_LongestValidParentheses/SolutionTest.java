package lc32_LongestValidParentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution s;

    @BeforeEach
    void setUp() {
        this.s = new Solution();
    }

    @Test
    void longestValidParentheses0() {
        assertEquals(0, s.longestValidParentheses(")"));
    }
    @Test
    void longestValidParentheses() {
        assertEquals(0, s.longestValidParentheses("("));
    }
    @Test
    void longestValidParenthesesa() {
        assertEquals(2, s.longestValidParentheses("()"));
    }
    @Test
    void longestValidParentheses1() {
        assertEquals(2, s.longestValidParentheses("(()"));
    }
    @Test
    void longestValidParentheses2() {
        assertEquals(4, s.longestValidParentheses(")()())"));
    }
    @Test
    void longestValidParentheses3() {
        assertEquals(6, s.longestValidParentheses("(())()(()(("));
    }
    @Test
    void longestValidParentheses4() {
        assertEquals(4, s.longestValidParentheses("(()()"));
    }
    @Test
    void longestValidParentheses5() {
        assertEquals(4, s.longestValidParentheses("))(()))))()"));
    }
}