package fb;

import java.util.HashMap;
import java.util.HashSet;

public class AlienOrder {

    public String alienOrder(String[] words) {
        HashMap<Character, Character> pairs = new HashMap<>();
        if(words.length == 0) return "";
        if(words.length == 1) return words[0];
        int x = 0;
        int y = 0;
        HashSet<Character> allCharacters = new HashSet<>();
        for(int i = 0; i < words.length ; i++) {
            for(int j = 0; j < words[i].length() ; j++) {
                allCharacters.add(words[i].charAt(j));
            }
        }

        while(y < words.length - 1) {
            if(x < words[y].length() && x < words[y+1].length()
                    && words[y].charAt(x) == words[y+1].charAt(x)) {
                // move left
                x++;
            } else {
                if(x < words[y].length() && x < words[y+1].length()) {
                    pairs.put(words[y].charAt(x), words[y+1].charAt(x));
                }
                // move down
                x = 0;
                y++;
            }
        }

        Character c = null;
        for(int i = 0; i < words.length && c == null; i++) {
            for(int j = 0; j < words[i].length() && c == null; j++) {
                if(pairs.containsKey( words[i].charAt(j))) {
                    c = words[i].charAt(j);
                }
            }
        }

        StringBuffer result = new StringBuffer();
        HashSet<Character> visited = new HashSet<>();
        allCharacters.remove(c);
        while(c != null) {
            if(visited.contains(c)) return "";
            visited.add(c);
            result.append(c);
            char p = c;
            c = pairs.get(c);
            if(c == null && pairs.size() > 0) {
                visited.remove(p);
                c = pairs.keySet().iterator().next();
            }

            allCharacters.remove(c);
            pairs.remove(p);
        }
        for(char remaining: allCharacters) result.append(remaining);
        return result.toString();
    }

    public static void main(String[] args) {
        int i = 1 / 2 ;
        System.out.println(i);
    }
}
