package bit;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * @author Gustavo
 *
 */
public class NumberOf1Bit {
	
	public int hammingWeight(int n) {
        int sum = n<0?1:0;
        int end = n<0?1:0;
        while(n != end) {
        	if((n & 1) == 1) sum++;
        	n = n >>> 1;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		NumberOf1Bit solution = new NumberOf1Bit();
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(solution.hammingWeight(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(solution.hammingWeight(Integer.MIN_VALUE));		
		System.out.println(Integer.toBinaryString(1));
		System.out.println(solution.hammingWeight(1));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(solution.hammingWeight(-1));
	

	}

}
