package lc109_ConvertSortedListBinarySearchTree;
/*
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.


 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode center = head, prev = null, dble = head;
        while (dble != null && dble.next != null) {
            prev = center;
            center = center.next;
            dble = dble.next.next;
        }
        prev.next = null;
        return new TreeNode(center.val, sortedListToBST(head), sortedListToBST(center.next));
    }
}