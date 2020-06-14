package lc92_ReverseLinkedList2;

/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = null, reverse = head, last = null, tail = null;

        for (int i = 1; i < m; i++) {
            tail = reverse;
            reverse = reverse.next;
        }
        last = reverse;

        for (int i = m; i < n; i++) {
            ListNode tmp = reverse;
            reverse = last.next;
            last.next = reverse.next;
            reverse.next = tmp;
        }
        if (m == 1) {
            result = reverse;
        } else {
            result = head;
            tail.next = reverse;
        }

        return result;
    }

}