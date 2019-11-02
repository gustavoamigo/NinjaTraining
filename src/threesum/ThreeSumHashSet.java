package threesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * https://oj.leetcode.com/problems/3sum/
 *
 * Solution using a HashSet (not very common).
 */
public class ThreeSumHashSet {

	public List<List<Integer>> threeSum(int[] arr) {
		Set<ArrayList<Integer>> solutions = new HashSet<>();
		if(arr.length < 3) return new ArrayList<>();

		Map<Integer, Integer> s = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			s.put(arr[i], i);
		}

		for(int j=0;j<arr.length-1;j++) {
			for(int k=j+1; k<arr.length; k++) {
				if(s.containsKey(-arr[j]-arr[k]) ) {
					int i = s.get(-arr[j]-arr[k]);
					if(i == j || i == k || k == j ) continue;
					ArrayList<Integer> solution = new ArrayList<>();
					solution.add(-arr[j]-arr[k]);
					solution.add(arr[j]);
					solution.add(arr[k]);
					Collections.sort(solution);
					solutions.add(solution);
				}
			}
		}
		return new ArrayList<>(solutions);
	}
}
