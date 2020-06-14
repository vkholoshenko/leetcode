package lc93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {
    private List<String> restore(String s, int segs) {
        List<String> result = new ArrayList<>();
        if (segs == 0) {
            if (s.length() == 0) {
                result.add("");
            }
        } else {
            if (s.length() > 0) {
                String prefix = s.substring(0, 1);
                for (String sub : restore(s.substring(1), segs-1)) {
                    if (segs>1) {
                        result.add(prefix + "." + sub);
                    } else {
                        result.add(prefix);
                    }
                }
            }
            if (s.length() > 1) {
                String prefix = s.substring(0, 2);
                if (prefix.charAt(0) != '0') {
                    for (String sub : restore(s.substring(2), segs-1)) {
                        if (segs>1) {
                            result.add(prefix + "." + sub);
                        } else {
                            result.add(prefix);
                        }
                    }
                }
            }
            if (s.length() > 2) {
                String prefix = s.substring(0, 3);
                if (Integer.parseInt(prefix) <= 255 && prefix.charAt(0) != '0') {
                    for (String sub : restore(s.substring(3), segs-1)) {
                        if (segs>1) {
                            result.add(prefix + "." + sub);
                        } else {
                            result.add(prefix);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<String> restoreIpAddresses(String s) {
        return restore(s, 4);
    }
}