package number;
/*
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class Division {
	/*
	 * 
	 * Divide two integers without using multiplication, division and mod operator.
	 * 
	 * Algorithm taken from Wikipedia http://en.wikipedia.org/wiki/Division_algorithm
	 * if D == 0 then throw DivisionByZeroException end
	 *	Q := 0                 initialize quotient and remainder to zero
	 *	R := 0                     
	 *	for i = n-1...0 do     where n is number of bits
	 *	  R := R << 1          left-shift R by 1 bit    
	 *	  R(0) := N(i)         set the least-significant bit of R equal to bit i of the numerator
	 *	  if R >= D then
	 *	    R = R - D               
	 *	    Q(i) := 1
     *	  end
	 *	end  
	 */
    static public int divide(int dividend, int divisor) {
        
    	if(divisor == 1) return dividend;
    	if(divisor == 0 || dividend == 0) return 0;

		int quotient = 0;
		int remainder = 0;
		
		for(int i = 31; i>=0; i--){
			
			//R := R << 1
			remainder = remainder << 1;
			
			// R(0) := N(i)
			if(dividend>=0) 
				{
					remainder |=  (dividend  >> i ) & 1;
					
				} else {
					remainder |=  ~(dividend  >> i ) & 1;
				}
			
			if( ( divisor > 0 ) && ( remainder >= divisor ) || ( divisor <0 ) && ( -remainder <= divisor ) ) {
				// R = R - D 
				if(divisor > 0 ) {
					remainder = remainder - divisor;
				} else {
					remainder = remainder + divisor;
				}
				
				// Q(i) := 1
				quotient |= 1 << i;
			}
		}
		
		if( dividend < 0 ) {
			remainder += 1;
			if( ( divisor > 0 ) && ( remainder >= divisor ) || (divisor < 0 ) && ( -remainder <= divisor ) ) quotient +=1;
		}
		
		if(( dividend <= 0 && divisor >= 0 ) || ( dividend >= 0 && divisor <= 0 )) quotient = -quotient;
		return quotient;
    }

	public static void main(String[] args) {
		
		System.out.println(divide(24,3));
		System.out.println(24/3);
		System.out.println(divide(25,3));
		System.out.println(25/3);
		System.out.println(divide(100,3));
		System.out.println(100/3);
		System.out.println(divide(111,5));
		System.out.println(111/5);		
		
		
		System.out.println(divide(-5,2));
		System.out.println(-5/2);
		System.out.println(divide(-5,-2));
		System.out.println(-5/-2);
		System.out.println(divide(5,-2));
		System.out.println(5/-2);
		System.out.println(divide(2147483647, 2));
		System.out.println(2147483647 / 2);
		System.out.println(divide(1312313, 2));
		System.out.println(1312313 / 2);
		

	}

}
