package lc86_PartitionList;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater
than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.


 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode result = null;
        ListNode lessTail = null;

        ListNode greaterHead = null;
        ListNode greaterTail = null;


        while (head != null) {
            if (head.val < x) {
                if (result == null) {
                    result = head;
                    lessTail = result;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
                head = head.next;
                lessTail.next = greaterHead;
            } else {
                if (greaterHead == null) {
                    greaterHead = head;
                    greaterTail = greaterHead;
                    if (lessTail != null) {
                        lessTail.next = greaterHead;
                    }
                } else {
                    greaterTail.next = head;
                    greaterTail = greaterTail.next;
                }
                head = head.next;
                greaterTail.next = null;
            }
        }
        if (result == null) {
            result = greaterHead;
        }
        return result;
    }
}