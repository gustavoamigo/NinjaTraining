package fb;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class Trie {
    static int  trieSize = 'z' - 'a' + 1; // lower-case English letters
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++) {
            Integer pos = word.charAt(i) - 'a';
            if(curr.links[pos] == null) curr.links[pos] = new TrieNode();
            curr = curr.links[pos];
            boolean isEnd = i == word.length() - 1;
            curr.isEnd = curr.isEnd || isEnd;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, 0);

    }

    private boolean search(TrieNode curr, String word, int pos) {
        if(pos >= word.length()) return false;
        char ch = word.charAt(pos);
        TrieNode node = curr.links[word.charAt(pos) - 'a'];
        if(node != null) {
            if(pos == word.length() - 1 && node.isEnd ) {
                return true;
            } else {
                return search(node, word,pos + 1);
            }
        } else {
            return false;
        }
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode curr, String word, int pos) {
        if(pos >= word.length()) return false;
        char ch = word.charAt(pos);
        TrieNode node = curr.links[word.charAt(pos) - 'a'];
        if(node != null) {
            if(pos == word.length() - 1) {
                return true;
            } else {
                return startsWith(node, word,pos + 1);
            }
        } else {
            return false;
        }
    }

    static class  TrieNode {
        boolean isEnd = false;
        TrieNode[] links = new TrieNode[trieSize];
        public TrieNode() {
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
