package fb;

import java.util.HashSet;

class IntersectArray {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();
    for(Integer i : nums1) {
      set1.add(i);
    }

    for(Integer i:nums2) {
      if(set1.contains(i)) {
        set2.add(i);
      }
    }

    int[] result = new int[set2.size()];
    int pos = 0;
    for(Integer i: set2) {
      result[pos] = i;
      pos++;
    }
    return result;
  }

  public static void main(String[] args) {
    IntersectArray intersectArray = new IntersectArray();
    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};
    int[] intersection = intersectArray.intersection(nums1, nums2);
    for(Integer i:intersection) {
      System.out.println(i);
    }
  }
}
