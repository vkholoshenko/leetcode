package lc347_TopKFrequent;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        List<HashSet<Integer>> byLength = new ArrayList<>();
        byLength.add(new HashSet<>());

        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num)+1);
            }
            int newCount = counts.get(num);
            byLength.get(newCount-1).remove(num);
            if (newCount > byLength.size() - 1) {
                byLength.add(new HashSet<>());
            }
            byLength.get(newCount).add(num);
        }

        int[] result = new int[k];
        int found = 0;

        for (int i = byLength.size()-1; i > 0; i--) {
            for (int num : byLength.get(i)) {
                result[found++] = num;
                if (found == k) {
                    return result;
                }
            }
        }
        return result;
    }
}