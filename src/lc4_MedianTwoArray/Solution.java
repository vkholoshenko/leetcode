package lc4_MedianTwoArray;

class Solution {
    public int find(int what, int[] where, int from, int to) {
        while (from <= to) {
            int mid = (from + to) / 2;
            if (where[mid] == what &&
                (mid + 1 == where.length || where[mid+1] > what)) {
                return mid + 1;
            } else if (where[mid] > what) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return from;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLeft = 0,  aRight = nums1.length - 1, bLeft = 0, bRight = nums2.length - 1;

        int target = (nums1.length + nums2.length - 1) / 2;
        boolean two = (nums1.length + nums2.length) % 2 == 0;
        int candidate, best = -1;

        while (aLeft <= aRight || bLeft <= bRight) {
            if (aLeft <= aRight) {
                candidate = nums1[(aLeft + aRight) / 2];
            } else {
                candidate = nums2[(bLeft + bRight) / 2];
            }
            int posA = find(candidate, nums1, aLeft, aRight);
            int posB = find(candidate, nums2, bLeft, bRight);
            int weight = posA + posB - 1;
            if (weight == target) {
                int second = candidate;
                if (two) {
                    if (posA < nums1.length && posB < nums2.length) {
                        second = Math.min(nums1[posA], nums2[posB]);
                    } else if (posA < nums1.length) {
                        second = nums1[posA];
                    } else {
                        second = nums2[posB];
                    }
                }
                return (candidate + second) * 0.5;
            } else if (weight > target) {
                best = candidate;
                aRight = find(candidate - 1, nums1, aLeft, aRight) - 1;
                bRight = find(candidate - 1, nums2, bLeft, bRight) - 1;
            } else {
                aLeft = posA;
                bLeft = posB;
            }
        }
        return best;
    }
}