package lc110_BalancedBinaryTree;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


 */
public class Solution {
    private int height(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -100;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
}