package array;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author Gustavo
 *
 */
public class RemoveDuplicates {
    private void removeElement(int[] a, int del) {
        System.arraycopy(a,del+1,a,del,a.length-1-del);
    }
    
    public int removeDuplicates(int[] A) {
        
        if(A.length<=1) return A.length;
        
        int i = 1;
        int length = A.length;
        
        while(i<length) {
            if(A[i] == A[i-1]) {
                removeElement(A, i);
                length--;
            } else {
                i++;
            }
        }
        return length;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicates instance = new RemoveDuplicates();
    	int[] a = {1,1};
    	System.out.println(instance.removeDuplicates(a));
    	System.out.println(Arrays.toString(a));
    	
    	int[] b = {1,2,3,3,4};
    	System.out.println(instance.removeDuplicates(b));
    	System.out.println(Arrays.toString(b));
    	
    	int[] c = {1,2,3,3};
    	System.out.println(instance.removeDuplicates(c));   
    	System.out.println(Arrays.toString(c));
    	
	}
}
