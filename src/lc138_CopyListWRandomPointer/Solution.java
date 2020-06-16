package lc138_CopyListWRandomPointer;

import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copies = new HashMap<>();
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copies.put(node, copy);
            node = node.next;
        }
        node = head;
        while (node != null) {
            Node copy = copies.get(node);
            copy.next = copies.get(node.next);
            copy.random = copies.get(node.random);
            node = node.next;
        }
        return copies.getOrDefault(head, null);
    }
}