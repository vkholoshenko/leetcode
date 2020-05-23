package lc56MergeIntervals;

public class Solution {
    public void sortIntervals(int[][] intervals, int start, int end) {
        int[] tmp;
        if (start >= end) {
            return;
        }
        int[] pivot = intervals[(start + end) / 2];

        int left = start;
        int right = end;

        while (left <= right) {
            while (intervals[left][0] < pivot[0]) {
                left++;
            }
            while (intervals[right][0] > pivot[0]) {
                right--;
            }
            if (left <= right) {
                tmp = intervals[left];
                intervals[left] = intervals[right];
                intervals[right] = tmp;
                left++;
                right--;
            }
        }
        sortIntervals(intervals, start, left-1);
        sortIntervals(intervals, left, end);
    }
    public void ensureLtR(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i][1]) {
                int t = intervals[i][0];
                intervals[i][0] = intervals[i][1];
                intervals[i][1] = t;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        ensureLtR(intervals);
        sortIntervals(intervals, 0, intervals.length-1);
        int c = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[c][1] >= intervals[i][0]) {
                if (intervals[i][1] > intervals[c][1]) {
                    intervals[c][1] = intervals[i][1];
                }
            } else {
                c++;
                intervals[c] = intervals[i];
            }
        }
        int[][] result = new int[c+1][2];
        for (int i = 0; i < c + 1; i++) {
            result[i] = intervals[i];
        }

        return result;
    }
}
