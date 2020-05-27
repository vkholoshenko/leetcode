package lc230_KthSmallestElementBST;

public class Solution {
    private Integer result = null;
    private int found = 0;
    private int target;

    private void traverse(TreeNode node) {
        if (node.left != null) {
            traverse(node.left);
        }
        if (this.result != null) {
            return;
        }
        this.found++;
        if (this.found == this.target) {
            this.result = node.val;
            return;
        }
        if (node.right != null) {
            traverse(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.target = k;
        traverse(root);
        if (this.result != null) {
            return this.result;
        } else {
            return -100500;
        }
    }
}
