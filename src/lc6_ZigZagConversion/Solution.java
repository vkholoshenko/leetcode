package lc6_ZigZagConversion;

/**
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        char[] result = new char[s.length()];
        int p = 0;
        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < s.length(); i += (2 * numRows - 2)) {
                result[p++] = s.charAt(i);
                if (r > 0 && r < numRows - 1) {
                    int pi = i + (2 * numRows - 2) - 2 * r;
                    if (pi < s.length()) {
                        result[p++] = s.charAt(pi);
                    }
                }
            }
        }
        return new String(result);
    }
}
