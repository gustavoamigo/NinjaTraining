package fb;

/* https://leetcode.com/problems/find-peak-element/ */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int i = nums.length / 2;
        int l = 0;
        int r = nums.length - 1;
        while(true) {
            int verify = verify(nums, i);
            if(verify == 0) {
                return i;
            } else if(verify == -1) {
                r = i - 1;
            } else {
                l = i + 1;
            }
            i = (l + r) / 2;
        }


    }

    public int verify(int[] nums, int pos) {
        if(nums.length == 1) return 0;
        if(pos == 0) {
            if(nums[0] > nums[1])
                return 0;
            else
                return 1;
        } else if (pos == nums.length - 1) {
            if(nums[nums.length - 2] < nums[nums.length - 1])
                return 0;
            else
                return -1;
        } else {
            if(nums[pos-1] < nums[pos] & nums[pos] > nums[pos+1])
                return 0;
            else if(nums[pos-1] < nums[pos] & nums[pos] < nums[pos+1])
                return 1;
            else
                return -1;
        }
    }
}
