package lc140_WordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty
words, add spaces in s to construct a sentence where each word is a valid dictionary
word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
 */
public class Solution {
    private HashMap<Integer, List<String>> cache = null;
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (this.cache == null) this.cache = new HashMap<>();
        if (!this.cache.containsKey(s.length())) {
            List<String> result = new ArrayList<>();
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    if (s.length() == word.length()) {
                        result.add(word);
                    } else {
                        for (String subResult : wordBreak(s.substring(word.length()), wordDict)) {
                            result.add(word + " " + subResult);
                        }
                    }
                }
            }
            this.cache.put(s.length(), result);
        }
        return this.cache.get(s.length());
    }
}