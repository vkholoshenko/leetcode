package lc99_RecoverBinarySearchTree;
/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 */
public class Solution {
    private TreeNode min = null;
    private TreeNode max = null;
    private TreeNode findFirstIncorrect(TreeNode root) {
        TreeNode result = null;
        if (root.left != null) {
            result = findFirstIncorrect(root.left);
        }
        if (result != null) {
            return result;
        }

        if (this.min != null && root.val < min.val) {
            return min;
        }

        this.min = root;
        if (root.right != null) {
            result = findFirstIncorrect(root.right);
        }
        return result;
    }

    private TreeNode findFirstCorrect(TreeNode root) {
        TreeNode result = null;
        if (root.left != null) {
            result = findFirstCorrect(root.left);
        }
        if (result != null) {
            return result;
        }

        if (root.val > min.val) {
            return this.max;
        }
        this.max = root;

        if (root.right != null) {
            result = findFirstCorrect(root.right);
        }
        return result;

    }
    public void recoverTree(TreeNode root) {
        TreeNode firstIncorrect = findFirstIncorrect(root);
        TreeNode firstCorrect = findFirstCorrect(root);
        if (firstCorrect == null) firstCorrect = this.max;

        int t = firstIncorrect.val;
        firstIncorrect.val = firstCorrect.val;
        firstCorrect.val = t;
    }
}