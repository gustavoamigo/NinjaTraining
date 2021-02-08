package fb;

import java.util.Stack;

public class ChechSubArray {
    public boolean checkSubarraySum(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(k == 0) {
                    if(sum == 0) return true;
                } else {
                    if(sum % k == 0) return true;
                }
            }
        }
        return false;
    }
}
