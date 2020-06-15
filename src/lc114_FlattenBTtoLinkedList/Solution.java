package lc114_FlattenBTtoLinkedList;
/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
class Solution {
    private TreeNode flattenAndReturnLast(TreeNode root) {
        TreeNode lastRight = null, lastLeft = null;
        if (root.right != null) {
            lastRight = flattenAndReturnLast(root.right);
        }

        if (root.left != null) {
            lastLeft = flattenAndReturnLast(root.left);
            lastLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (lastRight != null) {
            return lastRight;
        } else if (lastLeft != null) {
            return lastLeft;
        } else {
            return root;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenAndReturnLast(root);
    }
}