// 123.买卖股票的最佳时机III
public class maxProfitV {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k_max = 2;
        int[][][] dp = new int[n][k_max+1][2];

        for (int i = 0; i < n; i++) {
            for (int k = k_max; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][k_max][0];
    }
}
