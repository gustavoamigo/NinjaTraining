package threesum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * https://oj.leetcode.com/problems/3sum/
 * 
 * Solution using a HashSet (not very common).
 */
public class ThreeSumHashSet {

	public ArrayList<ArrayList<Integer>> threeSum(int[] arr) {
		Set<ArrayList<Integer>> solutions = new HashSet<ArrayList<Integer>>();
		if(arr.length < 3) return new ArrayList<ArrayList<Integer>>();
		
		Map<Integer, Integer> s = new HashMap<Integer, Integer>();
		
		
		for(int i=0;i<arr.length;i++) {
			s.put(arr[i], i);
		}
		
		for(int j=0;j<arr.length-1;j++) {
			for(int k=j+1; k<arr.length; k++) {
				if(s.containsKey(-arr[j]-arr[k]) ) {
					int i = s.get(-arr[j]-arr[k]);
					if(i == j ||  i == k || k == j ) continue;
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(-arr[j]-arr[k]);
					solution.add(arr[j]);
					solution.add(arr[k]);
					Collections.sort(solution);
					solutions.add(solution);
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(solutions);
	}
}
