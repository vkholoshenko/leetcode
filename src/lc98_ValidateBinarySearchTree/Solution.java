package lc98_ValidateBinarySearchTree;

class Solution {
    public boolean validate(TreeNode root, Integer minValue, Integer maxValue) {
        return
                root == null ||
                        (maxValue == null || root.val < maxValue) &&
                                (minValue == null || root.val > minValue) &&
                                validate(root.left, minValue, root.val) &&
                                validate(root.right, root.val, maxValue);
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}