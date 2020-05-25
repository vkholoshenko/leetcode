package lc102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    static class QueueItem {
        TreeNode node;
        int level;
        public QueueItem(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<QueueItem> q = new ArrayDeque<>();

        if (root != null) {
            q.add(new QueueItem(root, 0));
        }


        while (!q.isEmpty()) {
            QueueItem qi = q.poll();
            if (qi.level >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(qi.level).add(qi.node.val);

            if (qi.node.left != null) {
                q.add(new QueueItem(qi.node.left, qi.level + 1));
            }
            if (qi.node.right != null) {
                q.add(new QueueItem(qi.node.right, qi.level + 1));
            }
        }
        return result;
    }
}