package other;

import java.util.*;

/*
 * https://oj.leetcode.com/problems/gray-code/
 */
public class GrayCode {
	
	
	LinkedList<Integer> queue;
	ArrayList<Integer> array;
	HashSet<Integer> visited;
	private void dfs(int u, int n) {
		array.add(u);
		visited.add(u);
		ArrayList<Integer> adj  = findAdj(u, n);
		for (Integer next : adj) {
			if(!visited.contains(next)) {
				dfs(next, n);
			}
		}
	}
	
	private ArrayList<Integer> findAdj(int u, int n) {
		ArrayList<Integer> adj = new ArrayList<Integer>();
		for(int i = 0; i<n;i++) {
			int a = u ^ (1 << i) ;
			adj.add(a);
		}
		return adj;
	}
	
	
    public ArrayList<Integer> grayCode(int n) {
    	queue = new LinkedList<Integer>();
    	array = new ArrayList<Integer>();
    	visited = new HashSet<Integer>();
    	dfs(0,n);
        return array;
    }
    
    public static void main(String[] args) {
    	GrayCode solution = new GrayCode();
    	ArrayList<Integer> result = solution.grayCode(11);
    	System.out.println(Arrays.toString(result.toArray()));
    	for (Integer integer : result) {
			System.out.println(Integer.toBinaryString(integer));
		}
		
	}

}
