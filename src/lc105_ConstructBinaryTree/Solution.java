package lc105_ConstructBinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildSubTree(List<Integer> preorder, List<Integer> inorder) {
        int head = preorder.get(0);

        HashSet<Integer> leftNumbers = new HashSet<>();

        List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> leftPreOrder = new ArrayList<>();

        List<Integer> rightInOrder = new ArrayList<>();
        List<Integer> rightPreOrder = new ArrayList<>();

        boolean left = true;
        for (int item : inorder) {
            if (item == head) {
                left = false;
            } else {
                if (left) {
                    leftNumbers.add(item);
                    leftInOrder.add(item);
                } else {
                    rightInOrder.add(item);
                }
            }
        }

        for (int item : preorder) {
            if (item != head) {
                if (leftNumbers.contains(item)) {
                    leftPreOrder.add(item);
                } else {
                    rightPreOrder.add(item);
                }
            }
        }
        TreeNode result = new TreeNode(head, null, null);
        if (!leftInOrder.isEmpty()) {
            result.left = buildSubTree(leftPreOrder, leftInOrder);
        }
        if (!rightInOrder.isEmpty()) {
            result.right = buildSubTree(rightPreOrder, rightInOrder);
        }
        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length > 0) {
            List<Integer> preorderList = new ArrayList<>();
            for (int i : preorder) {
                preorderList.add(i);
            }
            List<Integer> inorderList = new ArrayList<>();
            for (int i : inorder) {
                inorderList.add(i);
            }
            return buildSubTree(preorderList, inorderList);
        } else {
            return null;
        }
    }
}