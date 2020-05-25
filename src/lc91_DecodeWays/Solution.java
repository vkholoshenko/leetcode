package lc91_DecodeWays;

class Solution {
    public int numDecodings(String s) {
        int preprev = 0, prev = 0, next;
        if (s.charAt(0) > '0') {
            preprev = 1;
            prev = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            next = 0;
            char prevChar = s.charAt(i - 1);
            char curChar = s.charAt(i);
            if (curChar > '0') {
                next += prev;
            }
            if (prevChar == '1' ||
                    prevChar == '2' && curChar >= '0' && curChar <= '6') {
                next += preprev;
            }
            preprev = prev;
            prev  = next;
        }
        return prev;
    }
}
