package lc19_RemoveNthNodeFromEndList;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head, prenth = head;

        for (int i = 1; i < n; i++) {
            current = current.next;
        }
        if (current.next == null) {
            return prenth.next;
        } else {
            current = current.next;
            while (current.next != null) {
                prenth = prenth.next;
                current = current.next;
            }
            prenth.next = prenth.next.next;
            return head;
        }
    }
}