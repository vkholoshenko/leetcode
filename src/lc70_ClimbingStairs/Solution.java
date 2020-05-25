package lc70_ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        int result=1, a=1, b=1;
        for (int i = 1; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}