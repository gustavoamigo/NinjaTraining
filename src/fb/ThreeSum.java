package fb;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
    Set<List<Integer>> repeated = new HashSet<>();

    // step 1
    for(int i=0;i<nums.length - 1;i++) {
      for(int j=1;j<nums.length;j++) {
        if(i!=j) {
          int a = Math.min(nums[i], nums[j]);
          int b = Math.max(nums[i], nums[j]);
          List<Integer> pairElements = new LinkedList<>();
          pairElements.add(a);
          pairElements.add(b);
          if(!repeated.contains(pairElements)) {
            int sum = nums[i] + nums[j];
            List<Integer> pair = new LinkedList<>();
            pair.add(i);
            pair.add(j);
            if(map.get(sum) == null) map.put(sum, new LinkedList<>());
            map.get(sum).add(pair);
            repeated.add(pairElements);
          }
        }
      }
    }
    HashSet<List<Integer>> result = new HashSet<>();
    for(int i=0;i<nums.length;i++) {
      int rest = -nums[i];
      List<List<Integer>> possibles = map.get(rest);
      if(possibles != null) {
        for(List<Integer> pairs : possibles) {
          if(pairs.get(0) != i && pairs.get(1) != i) {
            List<Integer> triplet = new LinkedList();
            triplet.add(nums[pairs.get(0)]);
            triplet.add(nums[pairs.get(1)]);
            triplet.add(nums[i]);
            triplet.sort(Comparator.comparingInt(Integer::intValue));
            result.add(triplet);
          }
        }
      }
    }

    List<List<Integer>> result2 = new LinkedList<>();
    for(List<Integer> triplet : result) result2.add(triplet);
    return result2;
  }

  public static void main(String[] args) {
    int[] array = {-1,0,1,2,-1,-4};

    List<List<Integer>> lists = new ThreeSum().threeSum(array);
    for(List<Integer> triplet: lists) {
      System.out.println(" ");
      for(Integer i: triplet) System.out.print(" " +i);
    }
  }
}
