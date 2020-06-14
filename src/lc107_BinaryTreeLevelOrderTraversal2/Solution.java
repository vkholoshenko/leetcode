package lc107_BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<TreeNode> currentLevel = new ArrayList<>(), nextLevel = null;
        if (root != null) {
            currentLevel.add(root);
        }
        while (!currentLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                level.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel;
            result.addFirst(level);
        }

        return result;
    }
}