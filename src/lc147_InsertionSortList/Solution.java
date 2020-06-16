package lc147_InsertionSortList;
/*
Sort a linked list using insertion sort.
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode first = head;
        ListNode last = first;
        ListNode current = head.next;

        while (current != null) {
            if (first.val > current.val) {
                last.next = current.next;
                current.next = first;
                first = current;
            } else {
                ListNode node = first;
                while (!node.next.equals(current) &&
                        node.next.val < current.val) {
                    node = node.next;
                }
                if (node.next.equals(current)) {
                    last = current;
                } else {
                    ListNode tmp = current.next;
                    current.next = node.next;
                    node.next = current;
                    last.next = tmp;
                }
            }
            current = last.next;
        }
        return first;
    }
}