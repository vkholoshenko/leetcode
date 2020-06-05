package lc77_Combinations;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> item = new ArrayList<>();
                item.add(i);
                result.add(item);
            }
        } else if (k > 1) {
            for (int f = n; f >= k; f--) {
                for (List<Integer> subres : combine(f-1, k-1)) {
                    subres.add(f);
                    result.add(subres);
                }
            }

        }
        return result;
    }
}