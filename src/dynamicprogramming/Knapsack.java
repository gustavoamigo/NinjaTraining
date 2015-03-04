package dynamicprogramming;
import java.util.*;

public class Knapsack {

	static public int knapsackWithRepetionRecursive(int kw, ArrayList<Integer> w, ArrayList<Integer> v) {
		System.out.println(kw);
		if (kw <= 0) return 0;
		
		int max = 0;
		
		for(int i = 0; i < w.size(); i++) {
			if(w.get(i) <= kw) {	
				int value = knapsackWithRepetionRecursive(kw - w.get(i), w, v) + v.get(i);
				if(value > max) max = value;
			}
		}
		return max;
	}
	
	static public int napsackWithRepetionIterative(int M, ArrayList<Integer> W, ArrayList<Integer> V) {
		int[] K = new int[M + 1];
		K[0] = 0;
		int best = 0;
		for(int w = 1; w<=M ; w++ ) {
			
			for(int i = 0; i<W.size(); i++) {
				if(w >= W.get(i)) {
					int value = K[w - W.get(i)] + V.get(i);
					if(value > best) best = value;
				}
			}
			K[w] = best;
		}
		 
		System.out.println(Arrays.toString(K));
		return K[M];
	}
	
	
	static public int knapsackWithRepetionRecursiveMemo(int kw, ArrayList<Integer> w, ArrayList<Integer> v, Map<Integer, Integer> memo) {
		if(memo == null) {
			memo = new HashMap<Integer, Integer>();
		}
		
		System.out.println(kw);
		if (kw <= 0) return 0;
		
		int max = 0;
		
		for(int i = 0; i < w.size(); i++) {
			if(w.get(i) <= kw) {	
				int value = 0;
				if(!memo.containsKey(kw - w.get(i))) {
					int  memoValue = knapsackWithRepetionRecursiveMemo(kw - w.get(i), w, v, memo);
					memo.put(kw - w.get(i), memoValue);
					value = memoValue + v.get(i);	
				} else {
					value = memo.get(kw - w.get(i)) + v.get(i);
				}
				if(value > max) max = value;
			}
		}
		return max;
	}	
	
	public static void main(String[] args) {
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(6);
		w.add(3);
		w.add(4);
		w.add(2);
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(30);
		v.add(14);
		v.add(16);
		v.add(9);
		
		System.out.println(napsackWithRepetionIterative(10, w, v));
		

	}

}
