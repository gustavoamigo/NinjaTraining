package fb;

import java.util.LinkedList;

class NextPermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;

    // find the first decreasing nums[i + 1] > nums[i]
    while(i >= 0 && !(nums[i + 1] > nums[i])) i--;

    if(i>=0) {
      // find nums[j] > nums[i] and swap
      int j = nums.length - 1;
      while (j >= 0 && !(nums[j] > nums[i])) j--;
      swap(nums, i, j);
    }

    // reverse the rest
    reverse(nums,i+1);
  }

  private void swap(int[] nums, int i, int j) {
    int aux = nums[i];
    nums[i] = nums[j];
    nums[j] = aux;
  }

  private void reverse(int[] nums, int pos) {
    if(pos >= nums.length) return;
    int i = pos;
    int j = nums.length - 1;
    while(i<j) {
      swap(nums, i, j);
      i ++;
      j --;
    }
  }
}
