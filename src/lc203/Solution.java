package lc203;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode result = head;
        ListNode item = result;
        while (item != null) {
            if (item.next != null && item.next.val == val) {
                item.next = item.next.next;
            } else {
                item = item.next;
            }
        }
        return result;
    }
}
