package lc128_LongestConsecutiveSequence;

import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> data = new HashMap<>();
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;

        for (int i : nums) {
            if (!data.containsKey(i)) {
                int newStart = i, newEnd = i; // ?

                if (data.containsKey(i - 1)) {
                    if (data.get(i - 1) > i) continue;
                    newStart = data.get(i - 1);
                    data.remove(i - 1);
                }
                if (data.containsKey(i + 1)) {
                    if (data.get(i + 1) < i) continue;
                    newEnd = data.get(i + 1);
                    data.remove(i + 1);
                }

                data.put(newStart, newEnd);
                if (newEnd > newStart) {
                    data.put(newEnd, newStart);
                    if (newEnd - newStart > max) {
                        max = newEnd - newStart;
                    }
                }
            }
        }

        return max + 1;
    }
}