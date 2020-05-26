package lc124_BinaryTreeMaximumPathSum;

class Solution {
    private int max;

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        int localMax = node.val + Math.max(0, leftSum) + Math.max(0, rightSum);

        if (localMax > max) {
            max = localMax;
        }
        return node.val + Math.max(0, Math.max(leftSum, rightSum));
    }

    public int maxPathSum(TreeNode root) {
        max = root.val;
        sum(root);
        return max;
    }
}