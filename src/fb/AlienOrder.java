package fb;

import java.util.*;

public class AlienOrder {

    public String alienOrder(String[] words) {

        if(words.length == 0) return "";
        if(words.length == 1) return words[0];

        HashMap<Character, Set<Character>> adj = new HashMap<>();
        int[] indegree = new int[26];

        // Reset the indegree table
        for(int i = 0 ; i < 26 ; i++) indegree[i] = -1;
        for(String word: words) {
            for(char c: word.toCharArray()) {
                if(indegree[c - 'a'] == -1) indegree[c - 'a'] = 0;
            }
        }

        // Create the adjacency list
        int x = 0;
        int y = 0;
        while(y < words.length - 1) {
            String firstWord = words[y];
            String secondWord = words[y+1];

            if (firstWord.length() > secondWord.length() && firstWord.startsWith(secondWord)) {
                return "";
            }
            if(x < firstWord.length() && x < secondWord.length()
                    && firstWord.charAt(x) == secondWord.charAt(x)) {
                // move left
                x++;
            } else {
                if(x < firstWord.length() && x < secondWord.length()) {
                    char source = firstWord.charAt(x);
                    char dest = secondWord.charAt(x);

                    if(!adj.containsKey(source)) adj.put(source, new HashSet<>());

                    if(!adj.get(source).contains(dest)) {
                        adj.get(source).add(dest);
                        indegree[dest - 'a']++;
                    }
                }
                // move down
                x = 0;
                y++;
            }
        }

        // Run a topological order using indegree algorithm
        Queue<Character> queue = new LinkedList<>();
        StringBuffer result = new StringBuffer();

        for(int i = 0; i<26 ; i++) {
            if(indegree[i] == 0) {
                queue.offer((char)(i +  'a'));
            }
        }

        while(queue.size() > 0) {
            char node = queue.poll();
            result.append(node);

            if(adj.containsKey(node)) {
                for(char neighbour: adj.get(node)) {
                    indegree[neighbour - 'a']--;
                    if(indegree[neighbour - 'a'] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        // we need to remove all indegree in order to be valid
        for(int i = 0; i<26 ; i++) {
            if(indegree[i] > 0) {
                return "";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int i = 1 / 2 ;
        System.out.println(i);
    }
}
