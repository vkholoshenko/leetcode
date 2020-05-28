package lc543_DiameterBinaryTree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution {
    private int best = 1;
    private int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculate(root.left);
        int right = calculate(root.right);
        int total = left + right + 1;
        if (total > best) {
            best = total;
        }
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return this.best-1;
    }}
