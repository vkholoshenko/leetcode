package lc127_WordsLadderr;

import java.util.*;

class Solution {
    private String[] dict;
    private int[] reached;


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }

        ArrayList<Integer>[] links = new ArrayList[wordList.size() + 1];
        int[] reached = new int[wordList.size() + 1];
        reached[0] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<Integer>();
        }

        int i = 0;
        for (String word : wordList) {
            i++;
            if (isOneStep(word, beginWord)) {
                links[0].add(i);
                links[i].add(0);
            }
        }

        i = 0;
        for (String word1 : wordList) {
            i++;
            if (word1.equals(endWord)) {
                q.add(i);
                reached[i] = -1;
            }
            int j = 0;
            for (String word2 : wordList) {
                j++;
                if (j > i && isOneStep(word1, word2)) {
                    links[i].add(j);
                    links[j].add(i);
                }
            }
        }

        while (!q.isEmpty()) {
            int el = q.poll();
            if (reached[el] > 0) {
                for (Integer next : links[el]) {
                    if (reached[next] < 0) {
                        return reached[el] - reached[next];
                    } else if (reached[next] == 0) {
                        q.add(next);
                        reached[next] = reached[el] + 1;
                    }
                }
            } else {
                for (Integer next : links[el]) {
                    if (reached[next] > 0) {
                        return reached[next] - reached[el];
                    } else if (reached[next] == 0) {
                        q.add(next);
                        reached[next] = reached[el] - 1;
                    }
                }
            }
        }

        return 0;
    }


    private int sortStep(int[] idx, int what, int from) {
        int end = idx.length - 1;
        while (from <= end) {
            while (from <= end && isOneStep(dict[idx[from]], dict[idx[what]])) {
                if (reached[idx[from]] == 0) {
                    reached[idx[from]] = reached[idx[what]] + 1;
                } else {
                    return -reached[idx[what]] - reached[idx[from]];
                }
                from++;
            }
            while (from <= end && !isOneStep(dict[idx[end]], dict[idx[what]])) {
                end--;
            }
            if (end > from) {
                int tmp = idx[from];
                idx[from] = idx[end];
                idx[end] = tmp;
                end--;
            }
        }
        return from;
    }

    public int ladderLength_better(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }

        dict = new String[wordList.size() + 1];
        dict[0] = beginWord;
        int i = 0;
        for (String word : wordList) {
            i++;
            dict[i] = word;
        }

        reached = new int[wordList.size() + 1];
        reached[0] = 1;

        int[] beginQueue = new int[wordList.size() + 1];
        int[] endQueue = new int[wordList.size() + 1];
        for (i = 1; i < dict.length; i++) {
            beginQueue[i] = i;
            endQueue[i] = i;
        }
        beginQueue[0] = 0;
        endQueue[0] = -1;
        for (i = 1; i < dict.length; i++) {
            if (dict[i].equals(endWord)) {
                endQueue[0] = i;
                endQueue[i] = 0;
                reached[i] = 1;
                break;
            }
        }
        if (endQueue[0] < 0) {
            return 0;
        }

        int beginHead = 0, beginTail = 1, endHead = 0, endTail = 1;

        while (beginHead < beginTail || endHead < endTail) {
            for (i = beginTail; i > beginHead; i--) {
                beginTail = sortStep(beginQueue, beginHead, beginTail);
                if (beginTail < 0) {
                    return -beginTail;
                }
                beginHead++;
            }

            for (i = endTail; i > endHead; i--) {
                endTail = sortStep(endQueue, endHead, endTail);
                if (endTail < 0) {
                    return -endTail;
                }
                endHead++;
            }
        }
        return 0;
    }

    public int ladderLength_good(String beginWord, String endWord, List<String> wordList) {
        String[] dict = new String[wordList.size() + 1];
        dict[0] = beginWord;
        int i = 0;
        for (String word : wordList) {
            i++;
            dict[i] = word;
        }

        int first = 0, last = 0, rest = 1, end, distance = 1;
        String tmp;
        while (first <= last) {
            while (first <= last) {
                if (dict[first].equals(endWord)) {
                    return distance;
                }
                end = dict.length - 1;
                while (rest <= end) {
                    while (rest <= end && isOneStep(dict[rest], dict[first])) {
                        rest++;
                    }
                    while (end >= rest && !isOneStep(dict[end], dict[first])) {
                        end--;
                    }
                    if (end > rest) {
                        tmp = dict[rest];
                        dict[rest] = dict[end];
                        dict[end] = tmp;
                        rest++;
                        end--;
                    }
                }
                first++;
            }
            distance++;
            first = last + 1;
            last = rest - 1;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        TreeSet<String> restWords = new TreeSet<>();
        restWords.addAll(wordList);

        int distance = 1;
        TreeSet<String> currentWords = new TreeSet<>();
        TreeSet<String> nextStep;
        currentWords.add(beginWord);

        // O(n^3 • k) - time complexity
        // O(n • k) - memory used

        while (!(currentWords.isEmpty() ||
                currentWords.contains(endWord))) {
            nextStep = new TreeSet<>();
            for (String currentWord : currentWords) {
                for (String wordFromDict : restWords) {
                    if (isOneStep(currentWord, wordFromDict)) {
                        nextStep.add(wordFromDict);
                    }
                }
            }
            for (String wordToDelete : nextStep) {
                restWords.remove(wordToDelete);
            }
            distance++;
            currentWords = nextStep;
        }

        if (currentWords.contains(endWord)) {
            return distance;
        } else {
            return 0;
        }
    }

    public boolean isOneStep(String word1, String word2) {
        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
            if (distance > 1) {
                return false;
            }
        }
        return distance == 1;
    }
}
