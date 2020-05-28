package lc297_SerializeBinaryTree;
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root != null) {
            Deque<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            TreeNode node;
            result = result + root.val + "|";
            while ((node = q.poll()) != null) {
                if (node.left != null) {
                    result = result + node.left.val;
                    q.add(node.left);
                }
                result += "|";

                if (node.right != null) {
                    result = result + node.right.val;
                    q.add(node.right);
                }
                if (!q.isEmpty()) {
                    result += "|";
                }
            }
        }
        return result;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode result = null;
        if (data.length() > 0) {
            boolean minus;
            result = new TreeNode(0);
            int index = 0;
            minus = false;
            while (data.charAt(index) != '|') {
                if (data.charAt(index) == '-') {
                    minus = true;
                } else {
                    result.val = result.val * 10 + data.charAt(index) - '0';
                }
                index++;
            }
            index++;
            if (minus) result.val = -result.val;

            Deque<TreeNode> nodes = new ArrayDeque<>();
            nodes.add(result);

            while (index < data.length()) {
                TreeNode node = nodes.poll();
                Integer val;
                // left
                val = null;
                minus = false;
                while (index < data.length() && data.charAt(index) != '|') {
                    if (val == null) { val = 0;}
                    if (data.charAt(index) == '-') {
                        minus = true;
                    } else {
                        val = val * 10 + data.charAt(index) - '0';
                    }
                    index++;
                }
                index++;
                if (val != null) {
                    if (minus) val = -val;
                    node.left = new TreeNode(val);
                    nodes.add(node.left);
                }

                // right
                minus = false;
                val = null;
                while (index < data.length() && data.charAt(index) != '|') {
                    if (val == null) { val = 0;}
                    if (data.charAt(index) == '-') {
                        minus = true;
                    } else {
                        val = val * 10 + data.charAt(index) - '0';
                    }
                    index++;
                }
                index++;
                if (val != null) {
                    if (minus) val = -val;
                    node.right = new TreeNode(val);
                    nodes.add(node.right);
                }
            }
        }

        return result;
    }
}