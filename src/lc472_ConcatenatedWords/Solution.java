package lc472_ConcatenatedWords;

import java.util.*;

/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Example:
 *
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 *  "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 *
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 */

class Solution {
    public boolean tryy(String word, int start, HashSet<String> dict) {
        if (start >= word.length()) {
            return true;
        }
        for (int i = start; i < word.length(); i++) {
            String prefix = word.substring(start, i + 1);

            if (dict.contains(prefix) && !prefix.equals(word) && tryy(word, i+1, dict)) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        HashSet<String> dict = new HashSet<>();
        Collections.addAll(dict, words);

        List<String> result = new ArrayList<>();
        for (String w : words) {
            if (!w.equals("") && tryy(w, 0, dict)) {
                result.add(w);
            }
        }
        return result;
    }
}