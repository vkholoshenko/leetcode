package lc44_WildcardMatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution s;

    @BeforeEach
    void setUp() {
        this.s=new Solution();
    }

    @Test
    void isMatch() {
        assertTrue(s.isMatch("adceb", "*a*b"));
    }

    @Test
    void isMatchTimeLimit() {
        assertFalse(s.isMatch(
                "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab",
                "b*b*ab**ba*b**b***bba"));
    }


    @Test
    void isMatchTimeLimit2() {
        assertFalse(s.isMatch(
                "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }


}