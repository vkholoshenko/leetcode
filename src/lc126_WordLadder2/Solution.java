package lc126_WordLadder2;

import java.util.*;

public class Solution {
    private boolean transformable(String w1, String w2) {
        int d = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) d++;
            if (d > 1) return false;
        }
        return d == 1;
    }

    private List<List<String>> buildBackPath(HashMap<String, HashSet<String>> paths, String endWord, String beginWord) {
        List<List<String>> result = new ArrayList<>();
        if (endWord.equals(beginWord)) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            result.add(path);
        } else {
            for (String from : paths.get(endWord)) {
                for (List<String> subpath : buildBackPath(paths, from, beginWord)) {
                    subpath.add(endWord);
                    result.add(subpath);
                }
            }
        }
        return result;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);
        HashMap<String, HashSet<String>> paths = new HashMap<>();
        HashSet<String> dictionary = new HashSet<>(wordList);

        String current;
        while ((current = q.poll()) != null) {
            int curLen = distance.get(current) + 1;
            if (distance.getOrDefault(endWord, curLen) < curLen) break;

            List<String> toDelete = new ArrayList<>();
            for (String next : dictionary) {
                int dist = distance.getOrDefault(next, curLen);
                if (dist < curLen) {
                    toDelete.add(next);
                }
                if (dist == curLen && transformable(current, next)) {
                    distance.put(next, curLen);
                    HashSet<String> path = paths.get(next);
                    if (path == null) {
                        path = new HashSet<>();
                        q.add(next);
                    }
                    path.add(current);
                    paths.put(next, path);
                }
            }
            for (String w : toDelete) {
                dictionary.remove(w);
            }
        }

        if (distance.containsKey(endWord)) {
            return buildBackPath(paths, endWord, beginWord);
        } else {
            return new ArrayList<>();
        }
    }
}