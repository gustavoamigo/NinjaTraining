package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/293/
class PermutaionWithRepetition {
  int[] nums;
  Set<List<Integer>> solution = new HashSet<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    this.nums = nums;
    recursive(0);
    return new ArrayList<>(solution);
  }

  private void swap(int i, int j) {
    if(i == j) return;
    int aux = nums[i];
    nums[i] = nums[j];
    nums[j] = aux;
  }

  private void recursive(int n) {
    if(n == nums.length - 1) {
      List<Integer> array = new LinkedList<>();
      for(int e: nums) array.add(e);
      solution.add(array);
    } else {
      for(int i = n; i < nums.length; i++) {
        swap(n, i);
        recursive(n + 1);
        swap(n, i);
      }
    }
  }
}
