package DP;

import java.util.Arrays;
// Topdown Approach uses recursion
public class FibonacciMemo {

    static int fibRec(int n, int[] memo) {
        // Base case
        if (n <= 1) {
            return n;
        }
        // To check if output already exists
        if (memo[n] != -1) {
            return memo[n];
        }
        // Calculate and save output for future use
        memo[n] = fibRec(n - 1, memo) + fibRec(n - 2, memo);
        return memo[n];
    }

    static int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibRec(n, memo);
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(fib(n));
    }
}
