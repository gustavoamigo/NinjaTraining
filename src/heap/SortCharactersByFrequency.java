package heap;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s.isEmpty()) return s;
        Map<Character, Integer> freq = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(!freq.containsKey(c)) {
               freq.put(c, 1);
            } else {
               freq.replace(c, freq.get(c) + 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue =
                new PriorityQueue<>(freq.size(), (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        priorityQueue.addAll(freq.entrySet());

        StringBuilder buff = new StringBuilder();
        while(!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            for(int i=0; i<entry.getValue(); i++) buff.append(entry.getKey());
        }

        return buff.toString();
    }

    public static void main(String[] args) {
        System.out.println((new SortCharactersByFrequency()).frequencySort("Aabb"));
    }

}
