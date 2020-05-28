package lc435_NonOverlappingIntervals;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

 */
class Solution {
    static class Interval {
        int start;
        int end;

        public Interval(int a, int b) {
            start = Math.min(a, b);
            end = Math.max(a, b);
        }
    }

    static class Comp implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }

        boolean equals(Interval a, Interval b) {
            return a.equals(b);
        }
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comp());
        for (int[] interval : intervals) {
            q.add(new Interval(interval[0], interval[1]));
        }

        int deleted = 0;
        if (!q.isEmpty()) {
            Interval in;

            int end = q.peek().start - 1;
            while ((in = q.poll()) != null) {
                if (in.start < end) {
                    deleted++;
                    if (in.end < end) end = in.end;
                } else {
                    end = in.end;
                }
            }
        }

        return deleted;
    }
}