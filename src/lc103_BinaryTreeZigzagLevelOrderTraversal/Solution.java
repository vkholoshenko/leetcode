package lc103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> nextLevel = null, currentLevel = new ArrayList<>();
        currentLevel.add(root);
        boolean reverse = false;

        while (!currentLevel.isEmpty()) {
            nextLevel = new ArrayList<>();
            LinkedList<Integer> items = new LinkedList<>();

            for (TreeNode node : currentLevel) {
                if (reverse) {
                    items.addFirst(node.val);
                } else {
                    items.add(node.val);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }

            }
            result.add(items);
            reverse = !reverse;
            currentLevel = nextLevel;
        }
        return result;
    }
}