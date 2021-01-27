package fb;

import java.util.HashMap;

// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/285/
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap();

        initHash(hash, t);
        StringBuffer candidate = new StringBuffer();
        String bestCandidate = "";
        for(int i = 0; i<s.length(); i++) {
            if(hash.containsKey(s.charAt(i))) {
                addChar(hash, s.charAt(i));
            } else {
                if(isWindowComplete(hash)) {
                    if(bestCandidate.equals("") || candidate.length() < bestCandidate.length()) {
                        bestCandidate = candidate.toString();
                    }
                }
                initHash(hash, t);
                candidate = new StringBuffer();
            }
        }
        return bestCandidate;
    }

    private void initHash(HashMap<Character, Integer> hash, String t) {
        for(int i = 0; i<t.length(); i++) hash.put(t.charAt(i), 0);
    }

    private void addChar(HashMap<Character, Integer> hash, char c) {
        hash.put(c, hash.get(c) +1);
    }

    private boolean isWindowComplete(HashMap<Character, Integer> hash) {
        for(Character key: hash.keySet()) {
            if(hash.get(key) == 0) return false;
        }
        return true;
    }
}
