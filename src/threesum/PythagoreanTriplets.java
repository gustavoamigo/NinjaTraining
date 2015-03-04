package threesum;

import java.util.*;

/*
 * Not a Leetcode Problem.
 *  
 * Given an array of integers, find Pythagorean triplets.
 * i.e. find a,b and c which satisfies a^2 + b^2 = c^2
 * Integers could be positive or negative.
 * 
 */

public class PythagoreanTriplets {
	

	public static List<Integer[]> findPythagorean(Integer[]  arr) {
		List<Integer[]> solutions = new ArrayList<Integer[]>();
		
		Map<Integer, Integer> s = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			// Powers two, but preservers signal
			if(arr[i]>=0) {
				s.put(arr[i]*arr[i], arr[i]); 
			} else {
				s.put(-1*arr[i]*arr[i], arr[i]);
			}
			
		}
		
		for(int j=0;j<arr.length-1;j++) {
			for(int k=j+1; k<arr.length; k++) {
				if(s.containsKey(arr[j]*arr[j]+arr[k]*arr[k]) ) {
					Integer[] solution = new Integer[3];
					solution[0] = arr[j];
					solution[1] = arr[k];
					solution[2] = s.get(arr[j]*arr[j]+arr[k]*arr[k]);
					solutions.add(solution);
				}
				if(s.containsKey(-(arr[j]*arr[j]+arr[k]*arr[k])) ) {
					Integer[] solution = new Integer[3];
					solution[0] = arr[j];
					solution[1] = arr[k];
					solution[2] = s.get(-(arr[j]*arr[j]+arr[k]*arr[k]));					
					solutions.add(solution);
				}		
			}
		}	
		return solutions;
	}
	
	public static void main(String[] args) {
		
		System.out.println("=======================");
		Integer[] arr2 = { -1, 4,-4, -5,5, 2, 3, 12, 13};
		List<Integer[]> solutions2  = findPythagorean(arr2);
		for(Integer[] solution : solutions2) {
			System.out.println(Arrays.toString(solution));
		}
	}
}
