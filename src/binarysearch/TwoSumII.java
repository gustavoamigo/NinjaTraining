package binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i<numbers.length; i++) {
            int j = binarySearch(numbers, target - numbers[i]);
            if(j != -1 && j != i) {
                int[] r = {Math.min(i+1, j+1), Math.max(i+1, j+1)};
                return r;
            }
        }
        int[] r = {0, 0};
        return r;
    }

    private static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while(true) {
            if(low > high) return -1;
            int pivot = low + (high - low)/2;
            if(numbers[pivot] == target) {
                return pivot;
            } else if(numbers[pivot] > target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
    }

    public int[] twoSumNotSoGood(int[] numbers, int target) {
        for(int i = 0; i<numbers.length; i++) {
            for(int j = i; j<numbers.length; j++) {
                if(i != j && numbers[i] + numbers[j] == target) {
                    int[] r = {i+1, j+1};
                    return r;
                }
            }
        }
        int[] r = {0, 0};
        return r;
    }
}
