package lc95_UniqueBinarySearchTrees2;

import java.util.ArrayList;
import java.util.List;
/*
Given an integer n, generate all structurally unique BST's (binary search trees)
 that store values 1 ... n.
 */
public class Solution {
    private List<TreeNode> subtree(int from, int to) {
        List<TreeNode> result = new ArrayList<>();
        if (from > to) {
            result.add(null);
        } else if (from == to) {
            result.add(new TreeNode(from));
        } else {
            for (int val = from; val <= to; val++) {
                for (TreeNode left : subtree(from, val-1)) {
                    for (TreeNode right : subtree(val+1, to)) {
                        result.add(new TreeNode(val, left, right));
                    }
                }
            }
        }
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        } else {
            return subtree(1, n);
        }
    }
}
