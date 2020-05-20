package lc5_Palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindrome() {
        Solution s = new Solution();
        assertEquals("bab", s.longestPalindrome("babad"));
    }

    @Test
    void longestPalindrome2() {
        Solution s = new Solution();
        assertEquals("bb", s.longestPalindrome("cbbd"));
    }
}