package lc88_MergeSortedArray;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pr = m + n - 1, p1 = m-1, p2 = n-1;
        while (pr >= 0) {
            if (p1 < 0 || p2 >= 0 && nums1[p1] < nums2[p2]) {
                nums1[pr] = nums2[p2];
                p2--;
            } else {
                nums1[pr] = nums1[p1];
                p1--;
            }
            pr--;
        }
    }
}