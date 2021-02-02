package fb;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void swap(int[] nums, int i, int j) {
        if(i == j) return;
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    private ArrayList<Integer> asList(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) arr.add(nums[i]);
        return arr;
    }

    private void backtrack(int[] nums, int first, ArrayList<List<Integer>> output) {
        if(first == nums.length) {
            output.add(asList(nums));
        }
        for(int i = first; i<nums.length; i++) {
            swap(nums, first, i);
            backtrack(nums, first + 1, output);
            swap(nums, first, i);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
}
