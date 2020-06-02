package lc30_SubstringConcatenationAllWords;

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
    void findSubstring() {
        System.out.println(s.findSubstring(
                "barfoofoobarthefoobarman",
                new String[]{"bar","foo","the"}));
    }
    @Test
    void findSubstring2() {
        System.out.println(s.findSubstring(
                "a",
                new String[]{"a"}));
    }
    @Test
    void findSubstring3() {
        System.out.println(s.findSubstring(
                "aaaaaaaa",
                new String[]{"aa","aa","aa"}));
    }
    @Test
    void findSubstring4() {
        System.out.println(s.findSubstring(
                "abababab",
                new String[]{"a","b","a"}));
    }
}