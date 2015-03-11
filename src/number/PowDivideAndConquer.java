package number;

/* 
 * https://leetcode.com/problems/powx-n/ 
 * Time : O(n)
 * Space: O(n)
 * */
public class PowDivideAndConquer {

    public double pow(double x, int n) {
        if(n>=0) return positivePow(x, n);
        else return 1/positivePow(x, Math.abs(n));
    }
    
    public double positivePow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x ;
        if(n%2 == 0 ) return pow(x, n/2) * pow(x, n/2);
        else return pow(x, n/2 + 1) * pow(x, n/2);
    }
    
	public static void main(String[] args) {
		PowDivideAndConquer p = new PowDivideAndConquer();
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
