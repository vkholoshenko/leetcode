package lc142_LinkedListCycle2;

public class Solution {
    private ListNode getNodeFromCycle(ListNode head) {
        ListNode p1 = head, p2 = head.next;
        while (!p1.equals(p2)) {
            if (p2.next == null || p2.next.next == null) return null;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fromCycle = getNodeFromCycle(head);
        if (fromCycle == null) return null;

        while (true) {
            ListNode node = fromCycle.next;
            do {
                if (head.equals(node)) return head;
                node = node.next;
            } while (!node.equals(fromCycle));
            head = head.next;
        }
    }
}