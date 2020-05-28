package lc572_IsSubtree;

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
    void isSubtree() {
        assertFalse(s.isSubtree(
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1,
                                        new TreeNode(0),
                                        null),
                                new TreeNode(2)),
                        new TreeNode(5)),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2))));
    }
}