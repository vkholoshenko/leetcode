package lc424_LongestRepeatingCharacterReplacement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution s;
    @BeforeEach
    void setUp() {
        s = new Solution();
    }

    @Test
    void characterReplacement1() {
        assertEquals(4, s.characterReplacement("AABABBA", 1));
    }
    @Test
    void characterReplacement2() {
        assertEquals(2, s.characterReplacement("AABABBA", 0));
    }
    @Test
    void characterReplacement3() {
        assertEquals(10, s.characterReplacement("ABABBABBAABBBAAAB", 3));
    }
}