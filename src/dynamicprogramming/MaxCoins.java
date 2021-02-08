package dynamicprogramming;

import java.util.Stack;

public class MaxCoins {

	
	public static Integer coinProblem(int[] values, int sum) {
		
		Integer[] min = new Integer[sum+1];

		
		for(int i=1; i<=sum;i++) {
			min[i] = null;
		}


		min[0] = 0;
		
		for(int i = 1 ; i<= sum; i++) {
			for(int j=0; j< values.length; j++) {
				
				if(     values[j]<=i // value is greater than the current sum value i, just skip
						&& min[i-values[j]] != null // there was no coin that would fit for the previous (i - currentCoin)
						&& (min[i] == null || min[i-values[j]] + 1 < min[i] 
						)
				   ) {
					min[i] = min[i - values[j]] + 1;	
				}
			}
		}
		return min[sum];
	}
	
	static public String  longestCommonSubsequenceRecursive (String a, String b) {
		
		if(a.isEmpty() || b.isEmpty()) return "";
		
		if(a.charAt(0) == b.charAt(0)) 
			return a.charAt(0) + longestCommonSubsequenceRecursive(a.substring(1), b.substring(1));
		
		String first = longestCommonSubsequenceRecursive(a.substring(1), b);
		String second = longestCommonSubsequenceRecursive(a, b.substring(1));
		if(first.length() >= b.length())  return first;
		return second;		
	}
	
	
	
	
	public static void main(String[] args) {
//		int[] values = {2,3,5};
//		System.out.println(coinProblem(values,10));
		System.out.println(longestCommonSubsequenceRecursive("AB", "DACACBE"));
	}

}
