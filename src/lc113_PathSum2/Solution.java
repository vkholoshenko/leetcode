package lc113_PathSum2;

import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each
path's sum equals the given sum.
 */
public class Solution {
    private List<List<Integer>> result;

    private void traverse(TreeNode root, List<Integer> path, int sum) {
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(path);
        }
        if (root.left != null) {
            traverse(root.left, new ArrayList<>(path), sum);
        }
        if (root.right != null) {
            traverse(root.right, new ArrayList<>(path), sum);
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root != null) traverse(root, new ArrayList<>(), sum);
        return result;
    }
}