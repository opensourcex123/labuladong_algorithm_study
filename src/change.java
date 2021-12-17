// 518.零钱兑换II
public class change {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j]代表背包容量为j时，前i个硬币能恰好装满背包的组合数
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
