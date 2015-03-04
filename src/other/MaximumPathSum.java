package other;

import java.util.*;

/*
 * Not a Leetcode problem
 * https://projecteuler.net/problem=18
 */
public class MaximumPathSum {
	
	private int p (ArrayList<ArrayList<Integer>> triangle, int n, int i) {
		
		if(i < 0) return Integer.MAX_VALUE;
		if(i > n) return  Integer.MAX_VALUE;
		if(i == 0 && n == 0) return triangle.get(0).get(0);
		
		int left = p(triangle, n-1, i-1);
		if(left != Integer.MAX_VALUE ) 
			left += triangle.get(n).get(i);
		
		int right = p(triangle, n-1, i);
		if(right != Integer.MAX_VALUE) 
			right += triangle.get(n).get(i);
		
		return Math.min( left, right);
	}
	
	
    public int minimumTotalMethod1(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size() - 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n ; i++) {
        	int v = p(triangle, n, i);
        	if(v<min) min = v;
        }
        return min;
    }
    
    
    public int minimumTotalMethod2(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
		
    	int size = triangle.size();
       
        int[][] p = new int[size][size+2];
        
        for(int i = 0; i < size; i++) {
        	p[i][0] = Integer.MAX_VALUE;
        	p[i][i+2] = Integer.MAX_VALUE;
        }
        
        p[0][1] = triangle.get(0).get(0);
        
        for(int n = 1; n < size; n++) {
        	
        	for(int i = 1; i <= n + 1; i++) {
        		
        		int left = p[n-1][i-1];
        		if(left != Integer.MAX_VALUE ) 
        			left += triangle.get(n).get(i-1);
        		
        		int right = p[n-1][i];
        		if(right != Integer.MAX_VALUE) 
        			right += triangle.get(n).get(i-1);
        		p[n][i] = Math.min( left, right);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= size ; i++) {
        	int v = p[size-1] [i];
        	if(v<min) min = v;
        }

        return min;
    }
    
    
    
    public static void main(String[] args) {
    	MaximumPathSum path = new MaximumPathSum(); 
    	
		Integer[] n0 = {2};
		Integer[] n1 = {3,4};
		Integer[] n2 = {6,5,7};
		Integer[] n3 = {4,1,8,3};
		Integer[] n4 = {3,9,9,2,5};
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>> ();
		triangle.add(new ArrayList<Integer>(Arrays.asList(n0)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(n1)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(n2)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(n3)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(n4)));
		
		System.out.println(path.minimumTotalMethod1(triangle));
		System.out.println(path.minimumTotalMethod2(triangle));
		
	}
 

}
