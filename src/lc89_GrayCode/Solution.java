package lc89_GrayCode;

import java.util.ArrayList;
import java.util.List;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        if (n > 0) {
            result.add(1);
        }
        int num = 1;
        for (int i = 1; i < n; i++) {
            num = num << 1;

            for (int j = result.size() - 1; j >=0; j--) {
                result.add(result.get(j) + num);
            }
        }

        return result;
    }
}