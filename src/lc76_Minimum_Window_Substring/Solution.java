package lc76_Minimum_Window_Substring;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> found = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            required.put(c, required.getOrDefault(c, 0) + 1);
            found.put(c, 0);
        }

        int start = -1, bestStart = -1, bestEnd = s.length();

        int toFind = t.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (required.containsKey(c)) {
                if (start < 0) start = i;

                found.put(c, found.get(c) + 1);

                if (toFind > 0 && found.get(c).equals(required.get(c))) {
                    toFind -= found.get(c);
                }
                if (toFind == 0) {
                    for (; start < i; start++) {
                        char ws = s.charAt(start);
                        if (required.containsKey(ws)) {
                            if (found.get(ws) > required.get(ws)) {
                                found.put(ws, found.get(ws)-1);
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (toFind == 0 && i - start < bestEnd - bestStart) {
                    bestStart = start;
                    bestEnd = i;
                }
            }
        }
        if (bestStart >= 0) {
            return s.substring(bestStart, bestEnd+1);
        } else {
            return "";
        }
    }
}