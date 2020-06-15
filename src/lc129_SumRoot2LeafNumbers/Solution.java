package lc129_SumRoot2LeafNumbers;
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.


 */
class Solution {
    private int result = 0;

    private void traverse(TreeNode node, int current) {
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            result += current;
        }
        if (node.left != null) {
            traverse(node.left, current);
        }
        if (node.right != null) {
            traverse(node.right, current);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root != null) traverse(root, 0);
        return result;
    }
}