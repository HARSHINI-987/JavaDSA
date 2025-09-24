package DP;
import java.util.Arrays;
public class CoinChangeDPOpti {
	 static int minCoins(int[] coins, int sum) {
		 	int[] dp = new int[sum + 1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = 0;
	        for (int i = coins.length - 1; i >= 0; i--) {
	            for (int j = 1; j <= sum; j++) {
	                int take = Integer.MAX_VALUE, noTake = Integer.MAX_VALUE;
	                if (j - coins[i] >= 0 && coins[i] > 0) {
	                    take = dp[j - coins[i]];
	                    if (take != Integer.MAX_VALUE) take++;
	                }
	                if (i + 1 < coins.length)
	                    noTake = dp[j];
	                dp[j] = Math.min(take, noTake);
	            }
	        }
	        return dp[sum] != Integer.MAX_VALUE ? dp[sum] : -1;
	    }
	 public static void main(String[] args) {
	        int[] coins = {9, 6, 5, 1};
	        int sum = 11;
	        System.out.println(minCoins(coins, sum));
	    }
}
