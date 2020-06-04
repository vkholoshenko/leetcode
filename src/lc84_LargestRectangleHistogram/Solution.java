package lc84_LargestRectangleHistogram;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example:
Input: [2,1,5,6,2,3]
Output: 10
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> index = new HashMap<>();
        pq.add(0);
        index.put(0, 0);
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = 0;
            if (i < heights.length) h = heights[i];

            int idx = i;
            while (h < pq.peek()) {
                max = Math.max(max, (i - index.get(pq.peek())) * pq.peek());
                idx = index.get(pq.peek());
                pq.poll();
            }
            if (h > pq.peek()) {
                index.put(h, idx);
                pq.add(h);
            }
        }
        return max;
    }
}