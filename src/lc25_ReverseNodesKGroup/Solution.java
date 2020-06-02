package lc25_ReverseNodesKGroup;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
public class Solution {
    private boolean canReverse(ListNode head, int k) {
        ListNode t = head;
        while (k > 0 && t != null) {
            t = t.next;
            k--;
        }
        return k == 0;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode prevTail = null;

        ListNode prev = null;
        ListNode curr = head;

        while (canReverse(head, k)) {
            ListNode first = head;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if (result == null) {
                result = prev;
            }
            head = curr;
            if (prevTail != null) {
                prevTail.next = prev;
            }
            prevTail = first;
            prevTail.next = curr;
        }
        return result;
    }
}