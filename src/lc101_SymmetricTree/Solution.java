package lc101_SymmetricTree;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3



 */
public class Solution {
    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSym(left.left, right.right) && isSym(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSym(root.left, root.right);
    }
}