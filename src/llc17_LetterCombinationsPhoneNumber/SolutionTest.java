package llc17_LetterCombinationsPhoneNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void letterCombinations() {
        for (String s : new Solution().letterCombinations("23")) {
            System.out.println(s);
        }
    }
}