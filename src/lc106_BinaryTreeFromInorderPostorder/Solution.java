package lc106_BinaryTreeFromInorderPostorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    private TreeNode buildSubTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.size() == 0) {
            return null;
        }
        TreeNode result = new TreeNode(postorder.get(postorder.size()-1));

        List<Integer> leftInOrder = new ArrayList<>(),
                rightInOrder = new ArrayList<>(),
                leftPostOrder = new ArrayList<>(),
                rightPostOrder = new ArrayList<>();
        boolean left = true;
        for (int i : inorder) {
            if (i == result.val) {
                left = false;
            } else {
                if (left) {
                    leftInOrder.add(i);
                } else {
                    rightInOrder.add(i);
                }
            }
        }
        HashSet<Integer> lefts = new HashSet<>(leftInOrder);

        for (int i : postorder) {
            if (i == result.val) {

            } else if (lefts.contains(i)) {
                leftPostOrder.add(i);
            } else {
                rightPostOrder.add(i);
            }
        }

        result.left = buildSubTree(leftInOrder, leftPostOrder);
        result.right = buildSubTree(rightInOrder, rightPostOrder);
        return result;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> io = new ArrayList<>();
        for (int i : inorder) io.add(i);
        List<Integer> po = new ArrayList<>();
        for (int i : postorder) po.add(i);
        return buildSubTree(io, po);
    }
}