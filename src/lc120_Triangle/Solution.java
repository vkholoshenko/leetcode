package lc120_Triangle;

import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer>
                    cur = triangle.get(i-1),
                    next  = triangle.get(i);

            next.set(0, next.get(0) + cur.get(0));
            next.set(i, next.get(i) + cur.get(i-1));


            for (int j = 1; j < i; j++) {
                next.set(j, next.get(j) + Math.min(cur.get(j), cur.get(j-1)));
            }
        }
        List<Integer> last = triangle.get(triangle.size()-1);
        int min = last.get(0);
        for (int i = 1; i < last.size(); i++) {
            min = Math.min(min, last.get(i));
        }
        return min;
    }
}