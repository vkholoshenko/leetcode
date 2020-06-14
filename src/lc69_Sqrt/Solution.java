package lc69_Sqrt;
/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer
part of the result is returned.
 */
public class Solution {
    public int mySqrt(int x) {
        if (x==0) return 0;
        int l = 1, r = x;
        while (l <= r) {
            int cand = (l+r) / 2;
            if (x / cand >= cand && x / (cand+1) <= cand) {
                return cand;
            }

            if (x / cand > cand) {
                l = cand + 1;
            } else {
                r = cand - 1;
            }
        }
        return l;
    }
}