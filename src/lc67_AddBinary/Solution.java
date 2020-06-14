package lc67_AddBinary;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.


 */
public class Solution {
    public String addBinary(String a, String b) {
        int pa = a.length()-1, pb = b.length()-1;
        int[] result = new int[Math.max(pa, pb) + 2];
        int pr = result.length-1;
        while (pa >= 0 || pb >= 0) {
            if (pa >= 0) {
                result[pr] += a.charAt(pa) - '0';
            }
            if (pb >= 0) {
                result[pr] += b.charAt(pb) - '0';
            }
            if (result[pr] > 1) {
                result[pr-1]++;
                result[pr]-=2;
            }
            pa--;
            pb--;
            pr--;
        }

        StringBuilder resp = new StringBuilder();
        int i = 0;
        while (result[i] == 0 && i < result.length-1) i++;
        while (i < result.length) {
            char c = (char)('0' + result[i]);
            resp.append(c);
            i++;
        }
        return resp.toString();
    }
}