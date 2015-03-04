package number;

/*
 * Not a Leetcode problem
 */
public class FibonacciProblems {
	
	public static int fibonacci(int n) {
		if( n == 0 ) return 0;
		if( n == 1 ) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int fibonacciIterative(int n) {
		int[] fib = new int[n + 1];
		if( n == 0 ) return 0;
		if( n == 1 ) return 1;
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<=n;i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib[n];
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			System.out.println(i + " -> " + fibonacci(i));
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(i + " -> " + fibonacciIterative(i));
		}		
	}

}
