package lc208_PrefixTree;

class Trie {
    static class Node {
        Node[] next;
        boolean isEnd;
        public Node() {
            this.isEnd = false;
            int r = 26;
            this.next = new Node[r];
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) {
            root.isEnd = true;
        } else {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.next[c-'a'] == null) {
                    current.next[c-'a'] = new Node();
                }
                current = current.next[c-'a'];
            }
            current.isEnd = true;
        }
    }

    private Node getNodeByPrefix(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next[c-'a'] == null) {
                return null;
            }
            current = current.next[c-'a'];
        }
        return current;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node byPrefix = getNodeByPrefix(word);
        return (byPrefix != null && byPrefix.isEnd);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNodeByPrefix(prefix) != null;
    }
}
