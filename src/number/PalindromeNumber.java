package number;

/*
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public int numberAt(int i, int pos) {
    	return ( (i % (int)Math.pow(10, pos) - i % (int)Math.pow(10, pos - 1)) / (int)Math.pow(10, pos - 1) );
    }
    
    public int size(int i) {
    	int size = 0;
    	while (i > 0) {
    		i = i / 10;
    		size++;
    	}
    	return size;
    } 
    
    public boolean isPalindrome(int x) {
    	if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return false;
        if(x<0) {
        	x = x * -1;
        }
        int size = size(x);
        for(int i=1;i<=size/2;i++){
            if(numberAt(x,i) != numberAt(x,size - i + 1)) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		PalindromeNumber s = new PalindromeNumber();
		System.out.println(s.isPalindrome(-2147447412));

	}

}
