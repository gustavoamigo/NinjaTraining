package fb;

// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/279/
class SearchRotatedSortedArray {
  public int search(int[] nums, int target) {
    if(nums.length == 0) return -1;
    int slice = findSlice(nums);
    int start = 0;
    int end = nums.length - 1;
    while (true) {
      if(start >= end && nums[translate(slice, nums.length, start)] != target) return -1;
      int pivot = start + (end - start) / 2;
      if(nums[translate(slice, nums.length, pivot)] == target) {
        return translate(slice, nums.length, pivot);
      } else if(nums[translate(slice, nums.length, pivot)] > target) {
        end = pivot - 1;
      } else {
        start = pivot + 1;
      }
    }
  }


  private int translate(int slice, int length, int index) {
    int result = slice + index;
    if(result>=length) result = result - length;
    return result;
  }

  private int findSlice(int[] nums) {
    int start = 0;
    int end = nums.length - 1; // 2

    while(true) {
      if(end-start<2) break;
      int pivot = start + (end - start) / 2;
      if(nums[pivot] > nums[start]) {
        start = pivot;
      } else {
        end = pivot;
      }
    }
    if(nums[start]>nums[end])
      return end;
    else return 0;
  }
}
