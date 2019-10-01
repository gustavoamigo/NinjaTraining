package fb;

// https://leetcode.com/problems/merge-sorted-array/
class MergeTwoArrays {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(n==0) return;
    if(m==0) {
      for(int i=0;i<n;i++) {
        nums1[i] = nums2[i];
      }
      return;
    }
    int p1 = m-1;
    int p2 = n-1;
    int p = m + n - 1;
    while(p>=0) {
      if(p1<0 || p2>=0 && nums1[p1] <= nums2[p2] ) {
        nums1[p] = nums2[p2];
        p2--;
      } else {
        nums1[p] = nums1[p1];
        p1--;
      }
      p--;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {0,0,0,0,0};
    int m = 0;
    int[] nums2 = {1,2,3,4,5};
    int n = 5;

    new MergeTwoArrays().merge(nums1, m, nums2, n);

    for(int i:nums1) {
      System.out.println(i);
    }
  }
}
