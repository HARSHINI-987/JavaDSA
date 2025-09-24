package DP;
//nth Fibonacci for DP
public class FibonacciRec {
	 static int fib(int n) {
	        if (n <= 1) {
	            return n;
	        }
	        return fib(n - 1) + fib(n - 2);
	    }

	    public static void main(String[] args) {
	        int n = 7;
	        System.out.println(fib(n));
	    }
}
