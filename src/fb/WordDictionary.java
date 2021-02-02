package fb;

/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
class WordDictionary {
    static int  trieSize = 'z' - 'a' + 1; // lower-case English letters
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++) {
            Integer pos = word.charAt(i) - 'a';
            if(curr.links[pos] == null) curr.links[pos] = new TrieNode();
            curr = curr.links[pos];
            boolean isEnd = i == word.length() - 1;
            curr.isEnd = curr.isEnd || isEnd;
        }
    }

    public boolean search(String word) {
        return prefix(root, word, 0);
    }

    private boolean prefix(TrieNode curr, String word, int pos) {
        if(pos >= word.length()) return false;
        char ch = word.charAt(pos);
        if(ch != '.') {
            TrieNode node = curr.links[word.charAt(pos) - 'a'];
            if(node != null) {
                if(pos == word.length() - 1 && node.isEnd ) {
                    return true;
                } else {
                    return prefix(node, word,pos + 1);
                }
            } else {
                return false;
            }
        } else {
            for(int i = 0; i < trieSize; i++) {
                if(curr.links[i] != null) {
                    TrieNode node = curr.links[i];
                    boolean result = pos == word.length() - 1 && node.isEnd || prefix(node,  word, pos + 1);
                    if(result) return true;
                }
            }
            return false;
        }
    }

    static class  TrieNode {
        boolean isEnd = false;
        TrieNode[] links = new TrieNode[trieSize];
        public TrieNode() {
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bah");
        System.out.println(dict.search("b..."));
    }
}


