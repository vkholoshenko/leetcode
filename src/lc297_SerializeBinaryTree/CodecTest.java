package lc297_SerializeBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {

    @Test
    void serialize() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertEquals("1|2|3|||4|5||||", new Codec().serialize(root));
    }

    @Test
    void deserialize() {
        TreeNode result = new Codec().deserialize("1|2|3|||4|5||||");
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertEquals(4, result.right.left.val);
        assertEquals(5, result.right.right.val);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
    @Test
    void serialize2() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        assertEquals("-1|0|1||||", new Codec().serialize(root));
    }

    @Test
    void deserialize2() {
        TreeNode result = new Codec().deserialize("-1|0|1||||");
        assertEquals(-1, result.val);
        assertEquals(0, result.left.val);
        assertEquals(1, result.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }
}