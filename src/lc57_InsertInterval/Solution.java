package lc57_InsertInterval;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int[][] newIntervals = new int[intervals.length+1][2];
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            newIntervals[i] = intervals[i];
            i++;
        }
        newIntervals[i] = newInterval;
        while (i < intervals.length) {
            newIntervals[i+1] = intervals[i];
            i++;
        }
        i = 0;
        for (int j = 1; j < newIntervals.length; j++) {
            if (newIntervals[i][1] >= newIntervals[j][0]) {
                newIntervals[i][1] = Math.max(newIntervals[i][1], newIntervals[j][1]);
            } else {
                i++;
                newIntervals[i] = newIntervals[j];
            }
        }
        int[][] result  = new int[i+1][2];
        for (int j = 0; j <= i; j++) {
            result[j] = newIntervals[j];
        }
        return result;
    }
}
