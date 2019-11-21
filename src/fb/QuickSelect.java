package fb;


// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
class QuickSelect {
    /*
    [3,2,1,5,6,4]

    [2,1,3,5,6,4]
    i = 2 is the 4th largest

    [2,1,3,4,5,6]
    i = 4 and is the 2nd largest

    */

  int[] nums;

  private void swap(int i, int j) {
    int aux = nums[i];
    nums[i] = nums[j];
    nums[j] = aux;
  }


  public int findKthLargest(int[] numsArg, int k) {
    this.nums = numsArg;
    int start = 0;
    int end = nums.length - 1;
    while(true) {
      int pivotIndex = start;
      int i = partition(pivotIndex, start, end);
      int candidate = nums.length - i;
      if(candidate == k) return nums[i];
      if(candidate>k) {
        start = i + 1;
      } else {
        end = i;
      }
    }
  }


  public int partition(int pivotIndex, int start, int end) {
    int index = start;
    int pivot = nums[pivotIndex];
    // move pivot to the right;
    swap(end, pivotIndex);

    // move all small numbers to the left
    for(int i = start; i<=end; i++) {
      if(nums[i]<pivot) {
        swap(i, index);
        index++;
      }
    }

    // move the pivot back to the
    swap(end, index);
    return index;
  }

  public static void main(String[] args) {
    QuickSelect quickSelect = new QuickSelect();
    int[] nums = {3,1,7};


    int kthLargest = quickSelect.findKthLargest(nums, 2);
    System.out.println(kthLargest);


  }
}
