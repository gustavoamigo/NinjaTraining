package string;

import java.util.*;
/*
 * https://oj.leetcode.com/problems/word-break/
 */
public class WordBreak {
	
    static class Tree {
        boolean isWord;
        HashMap<Character, Tree> children = new HashMap<Character, Tree>();;
    }
    
    private Tree head;
    
    private void buildTree(Set<String> dict) {
        for(String word:dict) {
            buildTree(word);
        }
    }
    
    private void buildTree(String word) {
        Tree current = head;
        for(int i=0;i<word.length();i++) {
            Character chr = word.charAt(i);
            if(!current.children.containsKey(chr)) current.children.put(chr, new Tree());
            current = current.children.get(chr);
        }
        current.isWord = true;
    }
       
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.isEmpty()) return false;
        if(dict == null || dict.size() == 0) return false;
        
        head = new Tree();
        
        buildTree(dict);
        
        int i = 0;
        int lastMatch = -1;
        
        Tree current = head;
        boolean match = false;
        
        while(i<s.length()) {
        	match = false;
            char chr = s.charAt(i);
            if(current.children.containsKey(chr)) 
            {
                current = current.children.get(chr); // next
                i++;                
                if(current.isWord) {
                    lastMatch = i;
                    match = true;
                } else if(i==s.length() && lastMatch > 0) {
                	i = lastMatch;
                    current = head;
                    lastMatch = -1;
                }
            } else if (lastMatch > 0) {
                i = lastMatch;
                current = head;
                lastMatch = -1;
            } else {
                return false;
            }
        }
        return match;
    }	

	public static void main(String[] args) {
		
		WordBreak word = new WordBreak();
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		System.out.println(word.wordBreak(s, dict));
		
		
		s = "leetacode";
		dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		System.out.println(word.wordBreak(s, dict));		
		
		s = "busbusabus";
		dict = new HashSet<String>();
		dict.add("bus");
		dict.add("busa");
		
		System.out.println(word.wordBreak(s, dict));
		
		s = "bb";
		dict = new HashSet<String>();
		dict.add("b");
		dict.add("a");
		dict.add("bbb");
		dict.add("bbbb");
		
		System.out.println(word.wordBreak(s, dict));	
		
		s = "bbabbbusbb";
		dict = new HashSet<String>();
		dict.add("b");
		dict.add("a");
		dict.add("bb");
		dict.add("bus");
		dict.add("bbbb");
		
		System.out.println(word.wordBreak(s, dict));			

		
		s = "aaaaaaa";
		dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aa");

		
		System.out.println(word.wordBreak(s, dict));
		
		s = "aaaaaaa";
		dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aa");
		dict.add("bb");
		
		System.out.println(word.wordBreak(s, dict));			
				
		
	}

}
