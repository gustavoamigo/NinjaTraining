package number;

/* 
 * https://leetcode.com/problems/powx-n/ 
 * Time : O(log n)
 * Space: O(log n)
 * */

public class PowDivideAndConquerWithTempVar {
    public double pow(double x, int n) {
        if(n>=0) return positivePow(x, n);
        else return 1/positivePow(x, Math.abs(n));
    }
    
    public double positivePow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x ;
        double temp = pow(x, n/2);
        double extraPower = n % 2 == 1 ? x : 1;
        return temp * temp * extraPower;
    }
    
	public static void main(String[] args) {
		PowDivideAndConquerWithTempVar p = new PowDivideAndConquerWithTempVar();
		System.out.println(p.pow(3,0));
		System.out.println(p.pow(3,1));
		System.out.println(p.pow(3,2));
		System.out.println(p.pow(3,3));
		System.out.println(p.pow(3,0));
		System.out.println(p.pow(3,-1));
		System.out.println(p.pow(3,-2));
		System.out.println(p.pow(3,-3));

	}
}
