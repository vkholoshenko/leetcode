package lc93_RestoreIPAddresses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.AssertHelper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution s;
    private AssertHelper<String> helper;

    @BeforeEach
    void setUp() {
        this.s = new Solution();
        this.helper = new AssertHelper<>();
    }

    @Test
    void restoreIpAddresses() {
        helper.assertSetEquals(
                s.restoreIpAddresses("010010"),
                Arrays.asList("0.10.0.10", "0.100.1.0"));
    }
}