package lc76_Minimum_Window_Substring;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minWindow() {
        assertEquals("BANC", new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void minWindow2() {
        assertEquals("ba", new Solution().minWindow("bba", "ab"));
    }

    @Test
    void minWindow3() throws IOException {

        assertEquals(new String(Files.readAllBytes(Paths.get("src/lc76_Minimum_Window_Substring/resources/tests/output1.txt"))),
                new Solution().minWindow(
                        new String(Files.readAllBytes(Paths.get("src/lc76_Minimum_Window_Substring/resources/tests/input1-string.txt"))),
                        new String(Files.readAllBytes(Paths.get("src/lc76_Minimum_Window_Substring/resources/tests/input1-substr.txt")))
                ));

    }
}

