package lc315CountSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    static class Node {
        public int val;
        public int size;
        public Node left = null;
        public Node right = null;
        public Node(int val) {
            this.val = val;
            this.size = 1;
        }
    }
    class BST {
        public Node head;
        private void add(int val, Node node) {
            node.size++;
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new Node(val);
                } else {
                    this.add(val, node.left);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(val);
                } else {
                    this.add(val, node.right);
                }
            }
        }
        public void add(int val) {
            if (head == null) {
                this.head = new Node(val);
            } else {
                this.add(val, head);
            }
        }
        public int calculate(int val, Node node) {
            if (node == null) return 0;
            int result = 0;
            if (val > node.val) {
                result++;
                if (node.left != null) result += node.left.size;
                return result + calculate(val, node.right);
            } else {
                return calculate(val, node.left) ;
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();

        BST bst = new BST();
        bst.add(nums[nums.length-1]);
        result.add(0);
        for (int i = nums.length-2; i >= 0; i--) {
            result.addFirst(bst.calculate(nums[i], bst.head));
            bst.add(nums[i]);
        }
        return result;
    }
}