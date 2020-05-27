package lc235_LowestCommonAncestorBST;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        int a = Math.min(p.val, q.val);
        int b = Math.max(p.val, q.val);
        while (true) {
            if (a == result.val || b == result.val || a < result.val && b > result.val) {
                break;
            } else if (b < result.val && result.left != null) {
                result = result.left;
            } else if (a > result.val && result.right != null) {
                result = result.right;
            } else {
                result = null;
                break;
            }
        }
        return result;
    }
}
