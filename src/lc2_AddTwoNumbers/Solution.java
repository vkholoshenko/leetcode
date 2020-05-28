package lc2_AddTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), current = null;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder != 0) {
            if (current == null) {
                current = result;
            } else {
                current.next = new ListNode(remainder);
                current = current.next;
            }
            if (l1 != null) {
                current.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current.val += l2.val;
                l2 = l2.next;
            }
            remainder = current.val / 10;
            current.val = current.val % 10;
        }
        return result;
    }
}