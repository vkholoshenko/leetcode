package lc3_LongestSubstring;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }

        boolean[] found = new boolean[255];
        found[s.charAt(0)] = true;
        int best = 1;
        int startIndex = 0, endIndex = 1;

        while (endIndex < s.length()) {
            if (found[s.charAt(endIndex)]) {
                while (s.charAt(startIndex) != s.charAt(endIndex)) {
                    found[s.charAt(startIndex)] = false;
                    startIndex++;
                }
                startIndex++;
                endIndex++;
            } else {
                found[s.charAt(endIndex)] = true;
                endIndex++;
                if (endIndex - startIndex > best) {
                    best = endIndex - startIndex;
                }
            }
        }
        return best;
    }
}