package lc117_PopulatingNextRightPointersEachNode2;

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node next = root.next, cnext = null;

        while (next != null && cnext == null) {
            if (next.left != null) {
                cnext = next.left;
            } else {
                cnext = next.right;
            }
            next = next.next;
        }
        if (root.right != null) {
            root.right.next = cnext;
            cnext = root.right;
            connect(root.right);
        }

        if (root.left != null) {
            root.left.next = cnext;
            connect(root.left);
        }

        return root;
    }
}