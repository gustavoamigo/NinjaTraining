package fb;

import java.util.ArrayList;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++) {
            if(!isAlienSorted(words[i], words[i+1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlienSorted(String word1, String word2, String order) {
        int minSize = Math.min(word1.length(), word2.length());
        for(int i = 0; i < minSize; i++) {
            if(word1.charAt(i) == word2.charAt(i)) {
                continue;
            } else {
                if(isCharsStored(word1.charAt(i), word2.charAt(i), order)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return word1.length() <= word2.length();
    }

    private boolean isCharsStored(char a, char b, String order) {
        Integer[] mult = new Integer[10];


        int posA = order.indexOf(a);
        int posB = order.indexOf(b);
        return posA <= posB;
    }
}
