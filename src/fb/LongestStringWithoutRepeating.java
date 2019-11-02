package fb;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LongestStringWithoutRepeating {
  public int lengthOfLongestSubstring(String s) {
    if(s.length() == 0) return 0;
    HashMap<Character, Integer> lastSeen = new HashMap<>();
    int start=0;
    int max=0;
    for(int i=0;i<s.length();i++) {
      Character c = s.charAt(i);
      if(lastSeen.get(c) != null) {
        start = Math.max(start, lastSeen.get(c) + 1);
      }
      max = Math.max(max, i - start + 1);
      lastSeen.put(c, i);
    }
    return max;
  }

  public static void main(String[] args) {
    LongestStringWithoutRepeating longestStringWithoutRepeating = new LongestStringWithoutRepeating();
    System.out.println(longestStringWithoutRepeating.lengthOfLongestSubstring("abba"));
    List<Integer> triplet = new LinkedList();
    triplet.sort(Comparator.comparingInt(Integer::intValue));
  }
}
