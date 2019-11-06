package fb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/278/
class PowerSet {
  Set<List<Integer>> solution = new HashSet<>();
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> list = new LinkedList<>();
    for(int i:nums) list.add(i);
    recursive(list);
    return new LinkedList<>(solution);
  }

  private void recursive(List<Integer> list) {
    solution.add(list);
    // 1,2,3
    for(Integer item: list) {
      List<Integer> newList = new LinkedList<>();
      for(Integer item2: list) {
        if(item != item2) {
          newList.add(item2);
        }
      }
      recursive(newList);
    }
  }
}
