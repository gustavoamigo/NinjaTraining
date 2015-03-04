package other;

import java.util.Arrays;
/*
 * https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {;
	    int i = 0;
	    int j = 0;
	    boolean shouldBreak = false;
	    for(i = 0; i < numbers.length - 1 && !shouldBreak; i++) {
	        for(j = i + 1; j < numbers.length && !shouldBreak; j++) {
	            if(numbers[i] + numbers[j] == target)
            	{
	            	shouldBreak = true;
            	}
	        }
	    }
	    int [] ans = new int[2];
	    ans[0] = i;
	    ans[1] = j;
	    return ans;
	}
	public static void main(String[] args) {
		int [] in = {5,75,25};
		TwoSum sol = new TwoSum();
		System.out.println(Arrays.toString(sol.twoSum(in, 100)));

	}

}
