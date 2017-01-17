package divideandconquer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode Majority Element - https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {


    public int majorityElement(int[] nums) {
        java.util.Arrays.sort(nums);
        int candidate = nums[0];
        int times = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == candidate) {
                times++;
                if(times > nums.length/2) return candidate;
            } else {
                candidate = nums[i];
                times = 1;
            }
        }
        return candidate;
    }



    // not so good solution
    public int majorityElementTLESolution(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int candidate = nums[i];
            int times = 0;
            for(int j=i;j<nums.length; j++) {
                if(nums[j] == candidate) times++;
                if(times > nums.length / 2) return candidate;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1};

          System.out.println((new MajorityElement()).majorityElement(nums));

//        Scanner scanner = new Scanner(System.in);
//        int s = scanner.nextInt();
//        int[] arr = new int[s];
//        for(int i=0;i<s;i++) arr[i] = scanner.nextInt();
//        System.out.println((new MajorityElement()).majorityElement(arr));

    }

}
