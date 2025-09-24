package DP;

public class FibonacciOpti {
	 static int fibo(int n) {
	        int first, second, output;

	        // Storing the independent values
	        first = 0;
	        second = 1;
	        output = 1;

	        // Using the bottom-up approach
	        for (int i = 2; i <= n; i++) {
	            output = first + second;
	            first = second;
	            second = output;
	        }

	        return output;
	    }

	    public static void main(String[] args) {
	        int n = 5;
	        System.out.println(fibo(n));
	    }
}
