package lc141_LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head != null) {
            ListNode p1 = head.next, p2 = head;
            while (p1 != null && p1.next != null && p1.next.next != null) {
                if (p1.equals(p2)) {
                    return true;
                }
                p1 = p1.next.next;
                p2 = p2.next;
            }
        }
        return false;
    }
}