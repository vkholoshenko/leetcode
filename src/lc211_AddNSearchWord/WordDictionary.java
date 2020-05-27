package lc211_AddNSearchWord;

import java.util.ArrayList;

class WordDictionary {
    static private final int R = 26;
    static class Node {
        Node[] next;
        boolean isEnd;
        public Node() {
            this.next = new Node[R];
            this.isEnd = false;
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next[c-'a'] == null) {
                current.next[c-'a'] = new Node();
            }
            current = current.next[c-'a'];
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        ArrayList<Node> current = new ArrayList<>();
        current.add(this.root);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            ArrayList<Node> next = new ArrayList<>();

            for (Node n : current) {
                if (c == '.') {
                    for (int j = 0; j < R; j++) {
                        if (n.next[j] != null) {
                            next.add(n.next[j]);
                        }
                    }
                } else if (n.next[c-'a'] != null) {
                    next.add(n.next[c-'a']);
                }
            }
            current = next;
        }
        for (Node n : current) {
            if (n.isEnd) {
                return true;
            }
        }
        return false;
    }
}

