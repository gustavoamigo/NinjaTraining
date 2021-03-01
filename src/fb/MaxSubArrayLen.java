package fb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 */
public class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();


        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> prefix = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == k) max = Math.max(max, i + 1);
            if(prefix.containsKey(sum - k)) {
                int j = prefix.get(sum - k);
                max = Math.max(max,  i - j);
            }
            prefix.putIfAbsent(sum, i);
        }
        return max;
    }
}
