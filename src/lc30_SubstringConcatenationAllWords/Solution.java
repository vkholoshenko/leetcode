package lc30_SubstringConcatenationAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
 */
public class Solution {
    private String s;
    private int wLen;
    private HashMap<String, Integer> dict;
    private int targetLength;

    private int trySubstring(int index) {
        int start = index;
        int length = 0;

        while (length < targetLength) {
            String w = s.substring(start, start + wLen);
            if (dict.getOrDefault(w, 0) > 0) {
                dict.put(w, dict.get(w) - 1);
                length += wLen;
                start += wLen;
            } else {
                break;
            }
        }
        for (int i = index; i < start; i += wLen) {
            String w = s.substring(i, i + wLen);
            dict.put(w, dict.get(w) + 1);
        }
        return length;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        this.s = s;
        this.wLen = words[0].length();
        this.targetLength = words.length * wLen;
        this.dict = new HashMap<>();
        for (String w : words) {
            this.dict.put(w, this.dict.getOrDefault(w, 0) + 1);
        }


        for (int offset = 0; offset < wLen; offset++) {
            int start = offset;

            while (start + targetLength <= s.length()) {
                int l = trySubstring(start);
                if (l == targetLength) {
                    result.add(start);
                    while (start + l + wLen <= s.length() &&
                            s.substring(start, start + wLen).equals(s.substring(start + l, start + l + wLen))) {
                        start += wLen;
                
                        result.add(start);
                    }
                }
                
                if (start + l + wLen <= s.length()) {
                    String w = s.substring(start + l, start + l + wLen);
                    if (dict.containsKey(w)) {
                        for (int i = start; i < start + l; i += wLen) {
                            if (s.substring(i, i + wLen).equals(w)) {
                                start = i + wLen;
                                break;
                            }
                        }
                    } else {
                        start = start + l + wLen;
                    }
                } else {
                    start += l;
                }
            }
        }

        return result;
    }
}