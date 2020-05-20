package lc3_LongestSubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
    }
    @Test
    void lengthOfLongestSubstring2() {
        Solution s = new Solution();
        assertEquals(1, s.lengthOfLongestSubstring("aaaaaaaa"));
    }
}