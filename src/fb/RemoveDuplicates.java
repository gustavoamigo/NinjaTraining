package fb;

/*
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3011/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int j = 1;
        int curr = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            if(curr != nums[i]) {
                nums[j] = nums[i];
                curr = nums[i];
                j++;
            }
        }
        return j;
    }
}
