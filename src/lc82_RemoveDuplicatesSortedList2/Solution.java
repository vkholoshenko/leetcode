package lc82_RemoveDuplicatesSortedList2;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = null, tail = null;

        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                while (head.next != null && head.next.val == head.val) {
                    head.next = head.next.next;
                }
                head = head.next;
            } else {
                if (result == null) {
                    result = head;
                    tail = result;
                } else {
                    tail.next = head;
                    tail = tail.next;
                }
                head = head.next;
            }
        }
        if (tail != null) {
            tail.next = null;
        }

        return result;
    }
}