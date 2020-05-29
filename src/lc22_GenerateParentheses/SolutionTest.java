package lc22_GenerateParentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generateParenthesis() {
        for (String s : new Solution().generateParenthesis(4)) {
            System.out.println(s);
        }
    }
}

/*
(((())))
((()()))
((())())
((()))()
(()(()))
(()()())
(()())()
(())()()

()((()))
()(()())
()(())()
()()(())
()()()()
 */
