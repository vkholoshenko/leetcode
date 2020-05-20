package lc3_LongestSubstring;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> found = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (found.contains(s.charAt(j))) {
                    break;
                }
                found.add(s.charAt(j));
                if (found.size() > best) {
                    best = found.size();
                }
            }
        }
        return best;
    }
}