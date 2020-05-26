package lcc139_WordBreak;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (can[i]) {
                for (String word : wordDict) {
                    if (i + word.length() <= s.length() &&
                            s.substring(i, i + word.length()).equals(word)) {
                        can[i + word.length()] = true;
                    }
                }
            }
        }

        return can[s.length()];
    }
}
