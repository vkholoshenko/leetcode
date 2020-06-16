package lc145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            node.right = null;

            if (left != null || right != null) {
                stack.push(node);
                if (right != null) stack.push(right);
                if (left != null) stack.push(left);
            } else {
                result.add(node.val);
            }
        }

        return result;
    }
}