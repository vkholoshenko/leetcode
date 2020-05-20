package lc11_Container;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maxArea(int[] height) {
        HashSet<Integer> uniqueHeights = new HashSet<>();
        HashMap<Integer, Integer> minIndex = new HashMap<>();
        HashMap<Integer, Integer> maxIndex = new HashMap<>();

        for (int i = 0; i < height.length; i++) {
            uniqueHeights.add(height[i]);
            if (!minIndex.containsKey(height[i])) {
                minIndex.put(height[i], i);
            }
            maxIndex.put(height[i], i);
        }

        int[] sortedHeights = new int[uniqueHeights.size()];
        int idx = 0;
        for (int h : uniqueHeights) sortedHeights[idx++] = h;
        Arrays.sort(sortedHeights);

        for (int i = sortedHeights.length - 2; i >= 0; i--) {
            int current = sortedHeights[i];
            int previous = sortedHeights[i+1];
            minIndex.put(current, Math.min(minIndex.get(current), minIndex.get(previous)));
            maxIndex.put(current, Math.max(maxIndex.get(current), maxIndex.get(previous)));
        }
        int result = 0;
        for (int h : sortedHeights) {
            int current = h * (maxIndex.get(h) - minIndex.get(h));
            if (current > result) {
                result = current;
            }
        }
        return result;
    }
}
