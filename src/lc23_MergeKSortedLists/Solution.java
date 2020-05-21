package lc23_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
        public boolean equals(ListNode a, ListNode b) {
            return a.equals(b);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNodeComparator comparator = new ListNodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode result = null, tail = null, current;
        while ((current = queue.poll()) != null) {
            if (result == null) {
                result = current;
                tail = result;
            } else {
                tail.next = current;
                tail = tail.next;
            }
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return result;
    }
}