package lc108_ConvertSortedArray2BST;
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Solution {
    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int c = (left + right) / 2;
        return new TreeNode(nums[c], build(nums, left, c-1), build(nums, c+1, right));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
}