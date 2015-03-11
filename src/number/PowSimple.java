package number;

/*
 * https://leetcode.com/problems/powx-n/ 
 * Time: O(n)
 * Space: O(1)
 */
public class PowSimple {
	
    public double pow(double x, int n) {
        if(n>=0) return positivePow(x, n);
        else return 1/positivePow(x, Math.abs(n));
    }
    
    public double positivePow(double x, int n) {
        if(n==0) return 1;
        double result = x;
        for(int i=0;i<n-1;i++) result = result * x;
        return result;
    }
    
	public static void main(String[] args) {
		PowSimple p = new PowSimple();
		System.out.println(p.pow(3,0));
		System.out.println(p.pow(3,1));
		System.out.println(p.pow(3,2));
		System.out.println(p.pow(3,3));
		System.out.println(p.pow(3,0));
		System.out.println(p.pow(3,-1));
		System.out.println(p.pow(3,-2));
		System.out.println(p.pow(3,-3));
		System.out.println(Math.pow(3,0));
		System.out.println(Math.pow(3,1));
		System.out.println(Math.pow(3,2));
		System.out.println(Math.pow(3,3));
		System.out.println(Math.pow(3,0));
		System.out.println(Math.pow(3,-1));
		System.out.println(Math.pow(3,-2));
		System.out.println(Math.pow(3,-3));
		

	}

}
