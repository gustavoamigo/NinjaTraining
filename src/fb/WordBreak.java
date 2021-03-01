package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    int[] memo = new int[0];

    class Trie {
        boolean isWord = false;
        HashMap<Character, Trie> children = new HashMap<>();
    }

    private Trie buildTrie(List<String> wordDict) {
        Trie root = new Trie();
        for(String word: wordDict) {
            Trie current = root;
            for(char c: word.toCharArray()) {
                if(!current.children.containsKey(c)) current.children.put(c, new Trie());
                current = current.children.get(c);
            }
            current.isWord = true;
        }
        return root;
    }

    private List<String> matches(String s, int pos, Trie trie) {
        List<String> matches = new ArrayList<>();
        StringBuffer word = new StringBuffer();
        for(char c: s.substring(pos).toCharArray()) {
            trie = trie.children.get(c);
            if(trie == null) break;
            word.append(c);
            if(trie.isWord) matches.add(word.toString());
        }
        return matches;
    }

    private boolean tryMatch(String s, int pos, Trie trie) {
        if(pos>=s.length()) return true;
        if(memo[pos] >= 0) return memo[pos] == 1;
        List<String> matches = matches(s, pos, trie);
        if(matches.isEmpty()) return false;
        for(String match: matches) {
            boolean isMatch = tryMatch(s, pos + match.length(), trie);
            if(isMatch){
                memo[pos] = 1;
                return true;
            }
        }
        memo[pos] = 0;
        return false;
    }


    /*
    W - dictionary size
    C - caracters per word
    S - String length
    O(S + W * WC)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = buildTrie(wordDict); // W * WC
        memo = new int[s.length()];
        for(int i=0;i<memo.length; i++) memo[i] = -1; // // S
        return tryMatch(s, 0, trie);

    }
}
