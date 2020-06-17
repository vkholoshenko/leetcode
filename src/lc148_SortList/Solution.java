package lc148_SortList;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pivot = head, first = null, second = null, node = head.next;

        pivot.next = null;
        while (node != null) {
            ListNode next = node.next;
            if (node.val > pivot.val) {
                node.next = second;
                second = node;
            } else {
                node.next = first;
                first = node;
            }
            node = next;
        }

        ListNode result = null, last = null;
        if (first != null) {
            result = sortList(first);
            node = result;
            while (node.next != null) node = node.next;
            node.next = pivot;
        } else {
            result = pivot;
        }
        pivot.next = sortList(second);

        return result;
    }
}