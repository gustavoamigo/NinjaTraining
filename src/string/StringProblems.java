package string;
import java.util.*;
public class StringProblems {
	
	public static void printPermutations(int[] n, int[] Nr, int idx) {
	    if (idx == n.length) {  //stop condition for the recursion [base clause]
	        System.out.println(Arrays.toString(n));
	        return;
	    }
	    for (int i = 0; i <= Nr[idx]; i++) { 
	        n[idx] = i;
	        printPermutations(n, Nr, idx+1); //recursive invokation, for next elements
	    }
	}
	
	public static void printHeapPermutation(int[] list) {
		printHeapPermutation(list.length, list);
	}
	private static void printHeapPermutation(int n, int[] list) {
		if(n == 0) { // Stop condition
			System.out.println(Arrays.toString(list));
			return;
		}
		
		for(int i = 0; i< n; i++) {
			printHeapPermutation(n-1, list);
			if(n % 2 == 1) {
				int temp = list[0];
				list[0] = list[n-1];
				list[n-1] = temp;
			} else {
				int temp = list[n-1];
				list[n-1] = list[i];
				list[i] = temp;
			}
		}
	}
	
	public static void printPermute2(int[] a, int i) {
		if(i==a.length-1) {
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int j = i; j< a.length; j++ ) {
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			printPermute2(a, i+1);
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
			
	}
	
	
	
	public static void main(String[] args) {

		int[] list = {2 , 3,3 , 4};
		printHeapPermutation(list);
		
		System.out.println("=================");
		
		printPermute2(list, 0);
		

	}

}
