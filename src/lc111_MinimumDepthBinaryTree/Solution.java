package lc111_MinimumDepthBinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        int level = 0;
        List<TreeNode> currentLevel = new ArrayList<>(), nextLevel = null;
        if (root != null) {
            currentLevel.add(root);
        }

        while (!currentLevel.isEmpty()) {
            level++;
            nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel;
        }

        return level;

    }
}