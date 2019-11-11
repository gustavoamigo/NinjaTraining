package fb;

class MoveZeros {
  private void swap(int[] nums, int i, int j) {
    if(i == j) return;
    int aux = nums[i];
    nums[i] = nums[j];
    nums[j] = aux;
  }
  public void moveZeroes(int[] nums) {
    int pos = 0;
    for(int i = 0; i<nums.length; i++) {
      if(nums[i] != 0) {
        swap(nums, i, pos);
        pos ++;
      }
    }
  }
}
