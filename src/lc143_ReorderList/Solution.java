package lc143_ReorderList;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode result = head, node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        int left = 1; int right = nodes.size() - 1;
        while (left <= right) {
            result.next = nodes.get(right);
            result = result.next;
            if (right > left) {
                result.next = nodes.get(left);
                result = result.next;
            }
            left++;
            right--;
        }
        if (result != null) {
            result.next = null;
        }
    }
}