package lc21_MergeTwoSortedLists;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, result = null, next, last = null;
        while (p1 != null || p2 != null) {
            if (p1 == null || (p2 != null && p2.val < p1.val)) {
                next = p2;
                p2 = next.next;
            } else {
                next = p1;
                p1 = next.next;
            }

            if (result == null) {
                result = next;
                last = result;
            } else {
                last.next = next;
                last = last.next;
            }
        }
        return result;
    }
}
